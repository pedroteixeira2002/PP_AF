package cbl;

import Interfaces.Event;
import Interfaces.EventController;
import application.ReadJSON;
import application.Template;
import exceptions.EditionNotActive;
import exceptions.EventAlreadyStarted;
import exceptions.IllegalDate;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import ma02_resources.project.Task;
import ma02_resources.project.exceptions.IllegalNumberOfTasks;
import ma02_resources.project.exceptions.TaskAlreadyInProject;

import java.io.IOException;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;


public class EditionImp implements Edition, EventController {
    private static int SIZE = 10;
    private final int FACTOR = 2;
    private String name;
    private LocalDate start;
    private LocalDate end;
    private String projectTemplate;
    private Status status;
    private int numberOfProjects;
    private int numberOfEvents;
    private Project[] projects;
    private Event[] events;

    public EditionImp(String name, LocalDate start, LocalDate end, String projectTemplate, Status status, Project[] projects, int numberOfProjects) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.projectTemplate = projectTemplate;
        this.status = status.INACTIVE;
        this.projects = new Project[SIZE];
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public LocalDate getStart() {
        return this.start;
    }

    @Override
    public String getProjectTemplate() {
        return this.projectTemplate;
    }

    @Override
    public Status getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public void addProject(String name, String description, String[] tags) throws IOException, ParseException {
        if (name == null || description == null || tags == null || tags.length == 0)
            throw new IllegalArgumentException("Arguments illegible");

        ReadJSON read = ReadJSON.getInstance();

        Template template = read.readJSON(this.start, this.projectTemplate);
        Task[] tasks = template.getTasks();
        Project project = new ProjectImp(name, description, tags, template.getNumber_of_students(), template.getNumber_of_partners(), template.getNumber_of_facilitators());
        for (Task task : tasks) {
            try {
                project.addTask(task);
            } catch (IllegalNumberOfTasks | TaskAlreadyInProject exception) {
                System.out.println(exception.getMessage());
            }
        }
        if (numberOfProjects == this.projects.length)
            expandProjects();
        this.projects[numberOfProjects] = project;
        this.numberOfProjects++;

    }

    @Override
    public void removeProject(String s) {
        Project that = getProject(s);
        int index = getIndex(that);
        if (index == -1) {
            throw new IllegalArgumentException("Project not found");
        }
        projects[index] = null;
        for (int i = index; i < numberOfProjects - 1; i++) {
            projects[i] = projects[i + 1];
        }
        System.out.println("Project removed with sucess");
    }

    public void expandProjects() {
        Project[] temp = new Project[this.projects.length * FACTOR];

        for (int i = 0; i < numberOfProjects; i++) {
            temp[i] = this.projects[i];
        }
        this.projects = temp;
    }

    @Override
    public Project getProject(String s) {
        return this.projects[0];
    }

    public int getIndex(Project project) {
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] == project)
                return i;
        }
        return -1;
    }

    @Override
    public Project[] getProjects() {
        return this.projects;
    }

    @Override
    public Project[] getProjectsByTag(String s) {
        int index = 0;
        Project[] array = new Project[20];
        for (Project project : projects) {
            if (project.getTags().equals(s)) ;
            array[index] = project;
            index++;
        }
        return array;
    }

    @Override
    public Project[] getProjectsOf(String s) {
        int index = 0;
        Project[] array = new Project[20];
        for (Project project : projects) {
            try {
                project.getParticipant(s);
            } catch (NullPointerException exception) {
                System.out.println("Participant not found");
            }
            array[index] = project;
            index++;
        }
        return array;
    }

    @Override
    public int getNumberOfProjects() {
        return this.numberOfProjects;
    }

    @Override
    public LocalDate getEnd() {
        return this.end;
    }

    public boolean isActive() throws EditionNotActive {
        if (this.status == Status.ACTIVE)
            return true;
        else
            throw new EditionNotActive("Edition is not active");
    }

    /**
     * @param event
     */
    @Override
    public void addEvent(Event event) throws IllegalArgumentException, IllegalDate, EditionNotActive {
        if (event == null)
            throw new IllegalDate("Event is null");
        try {
            isActive();
            hasEvent(event);
        } catch (EditionNotActive exception) {
            System.out.println(exception.getMessage());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        if (event.getStartDate().isAfter(this.start) == true &&
                event.getEndDate().isBefore(this.end) == true &&
                event.getStartDate().isAfter(LocalDate.now()) == true) {
            throw new IllegalDate("Event must start after today and between the start and end of the edition");
        }

        if (numberOfEvents == this.events.length)
            expandEvents();


        this.events[numberOfEvents] = event;
        this.numberOfEvents++;
    }

    /**
     * @return
     */
    @Override
    public boolean removeEvent(Event event) throws EventAlreadyStarted {
        if (event.getStartDate().isAfter(LocalDate.now()) == true)
            throw new EventAlreadyStarted("Event already started");
        int index = findEvent(event);
        if (index == -1)
            return false;
        events[index] = null;
        for (int i = index; i < numberOfEvents - 1; i++)
            events[i] = events[i + 1];
        this.numberOfEvents--;
        return true;
    }

    /**
     * @return the updated event
     */
    @Override
    public Event updateEvent(Event event, String location, LocalDate startDate, LocalDate endDate) throws
            IllegalArgumentException, EventAlreadyStarted {
        if (event.getStartDate().isAfter(LocalDate.now()) == true)
            throw new EventAlreadyStarted("Event already started");
        if (event == null)
            throw new IllegalArgumentException("Event is null");

        try {
            hasEvent(event);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        event.setLocation(location);
        event.setStartDate(startDate);
        event.setEndDate(endDate);

        return event;
    }

    /**
     * @return the events of the project
     */
    @Override
    public void listEvent() {
        for (Event event : events) {
            event.toString();
        }
    }

    public void listProjects() {
        for (int i = 0; i < numberOfProjects; i++) {
            System.out.println(projects[i].toString());
        }
        System.out.println(numberOfProjects + "/" + projects.length);
    }

    public void hasEvent(Event event) throws IllegalArgumentException {
        for (int i = 0; i < numberOfEvents; i++) {
            if (this.events[i].equals(event)) {
                throw new IllegalArgumentException("Invalid number of days");
            }
        }
    }

    public void expandEvents() {
        Event[] temp = new Event[this.events.length * FACTOR];

        for (int i = 0; i < numberOfEvents; i++) {
            temp[i] = this.events[i];
        }
        this.events = temp;
    }

    public int findEvent(Event event) {
        for (int i = 0; i < numberOfEvents; i++) {
            if (this.events[i].equals(event)) {
                return i;
            }
        }
        return -1;
    }

    public String getProgress() {
        int completedTasks = 0;
        int countTasks = 0;

        for (Project project : this.getProjects()) {
            for (Task task : project.getTasks()) {
                countTasks++;
                if (task.getNumberOfSubmissions() != 0) {
                    completedTasks++;
                }
            }
        }
        return ("\nCompleted: " + completedTasks +
                "\nTotal Tasks: " + countTasks +
                "\nThe Edition is: " + (completedTasks * 100) / countTasks + "% completed");
    }

    @Override
    public String toString() {
        return "\n Edition{" +
                "\n Name: " + name +
                "\n Start Date: " + start +
                "\n End Date: " + end +
                "\n Status: " + status +
                "\n Number Of Projects: " + numberOfProjects +
                "\n Number Of Events: " + numberOfEvents +
                "\n Projects: " + Arrays.toString(projects) +
                "\n Events=" + Arrays.toString(events);
    }
}

