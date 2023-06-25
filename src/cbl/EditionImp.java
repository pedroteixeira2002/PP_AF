/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

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

/**
 * this class represents an edition
 */
public class EditionImp implements EventController, Edition {
    private static int SIZE = 10;
    private final int FACTOR = 2;
    private String name;
    private LocalDate start;
    private LocalDate end;
    private final String projectTemplate = "project_template.json";
    private Status status;
    private int numberOfProjects;
    private int numberOfEvents;
    private Project[] projects;
    private Event[] events;

    /**
     * constructor of the class
     * @param name the name of the edition
     * @param start the start date of the edition
     * @param end the end date of the edition
     * @param status the status of the edition
     * @param projects the projects of the edition
     * @param events the events of the edition
     */
    public EditionImp(String name, LocalDate start, LocalDate end, Status status, Project[] projects, Event[] events) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.status = status.INACTIVE;
        this.projects =projects;
        this.events = events;
    }

    /**
     * constructor of the class
     * @param name the name of the edition
     * @param start the start date of the edition
     * @param end the end date of the edition
     * @param status the status of the edition
     */
    public EditionImp(String name, LocalDate start, LocalDate end, Status status) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.status = status;
        this.projects = new Project[SIZE];
        this.events = new Event[SIZE];
    }

    /**
     * this method gets the name of the edition
     * @return the name of the edition
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * this name gets the start date of the edition
     * @return the start date of the edition
     */
    @Override
    public LocalDate getStart() {
        return this.start;
    }

    /**
     * this method gets the project template
     * @return the project template
     */
    @Override
    public String getProjectTemplate() {
        return this.projectTemplate;
    }

    /**
     * this method gets the number of  events
     * @return the number of events
     */
    @Override
    public int getNumberOfEvents() {
        return numberOfEvents;
    }

    /**
     * this method gets the events
     * @return the events
     */
    @Override
    public EventImp[] getEvents() {
        return (EventImp[]) events;
    }

    /**
     * this method gets the status of the edition
     * @return the status of the edition
     */
    @Override
    public Status getStatus() {
        return this.status;
    }

    /**
     * this method sets the status of the edition
     * @param status the status of the edition
     */
    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * this method add a project to the edition
     * @param name the name of the project
     * @param description the description of the project
     * @param tags the tags of the project
     * @throws IOException if the file is not found
     * @throws ParseException if the date is not in the correct format
     */
    @Override
    public void addProject(String name, String description, String[] tags) throws IOException, ParseException {
        if (name == null || description == null || tags == null || tags.length == 0)
            throw new IllegalArgumentException("Arguments illegible");

        ReadJSON read = ReadJSON.getInstance();

        Template template = read.readTemplate(this.start, this.projectTemplate);
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

    /**
     * this method remove a project from the edition
     * @param s the name of the project
     */
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

    /**
     * this method expand the projects array
     */
    private void expandProjects() {
        Project[] temp = new Project[this.projects.length * FACTOR];

        for (int i = 0; i < numberOfProjects; i++) {
            temp[i] = this.projects[i];
        }
        this.projects = temp;
    }

    /**
     * this method gets the project
     */
    @Override
    public Project getProject(String s) {
        return this.projects[0];
    }

    /**
     * this method gets the index of the project
     * @param project the project
     * @return the index of the project
     */
    public int getIndex(Project project) {
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] == project)
                return i;
        }
        return -1;
    }

    /**
     * this method gets the number of projects
     * @return
     */
    @Override
    public ProjectImp[] getProjects() {
        return (ProjectImp[]) this.projects;
    }

    /**
     * this method gets the projects by tag
     * @param s the tag
     * @return the projects by tag
     */
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

    /**
     * this method gets the projects of a participant
     * @param s the participant
     * @return the projects of a participant
     */
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

    /**
     * this method gets the number of projects
     * @return the number of projects
     */
    @Override
    public int getNumberOfProjects() {
        return this.numberOfProjects;
    }

    /**
     * this method gets the end date
     * @return the end date
     */
    @Override
    public LocalDate getEnd() {
        return this.end;
    }

    /**
     * this method checks if the edition is active
     * @return true if the edition is active
     * @throws EditionNotActive if the edition is not active
     */
    public boolean isActive() throws EditionNotActive {
        if (this.status == Status.ACTIVE)
            return true;
        else
            throw new EditionNotActive("Edition is not active");
    }

    /**
     * this method adds a event to the edition
     * @param event the event
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
     * this method remove a event from the edition
     * @return true if the event was removed
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
     * this method update event
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
     * this method list an event
     * @return the events of the project
     */
    @Override
    public void listEvent() {
        for (Event event : events) {
            event.toString();
        }
    }

    /**
     * this method list the projects
     * @return the projects
     */
    public void listProjects() {
        for (int i = 0; i < numberOfProjects; i++) {
            System.out.println(projects[i].toString());
        }
        System.out.println(numberOfProjects + "/" + projects.length);
    }

    /**
     * this method checks if the edition has a event
     * @return the event
     */
    public void hasEvent(Event event) throws IllegalArgumentException {
        for (int i = 0; i < numberOfEvents; i++) {
            if (this.events[i].equals(event)) {
                throw new IllegalArgumentException("Invalid number of days");
            }
        }
    }

    /**
     * this method expands the events
     */
    public void expandEvents() {
        Event[] temp = new Event[this.events.length * FACTOR];

        for (int i = 0; i < numberOfEvents; i++) {
            temp[i] = this.events[i];
        }
        this.events = temp;
    }

    /**
     * this method finds a event
     * @param event the event
     * @return the event
     */
    public int findEvent(Event event) {
        for (int i = 0; i < numberOfEvents; i++) {
            if (this.events[i].equals(event)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * this method gets the progress of the edition
     * @return the progress
     */
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

    /**
     * this method gives the information of the edition
     * @return the information
     */
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

