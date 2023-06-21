package CBL;

import Interfaces.Event;
import Interfaces.EventController;
import exceptions.EditionNotActive;
import exceptions.EventAlreadyStarted;
import exceptions.IllegalDate;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import ma02_resources.project.Task;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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
    public void addProject(String s, String s1, String[] strings) throws IOException, ParseException {
        try {
            Reader reader = new FileReader("json_files\\projectTemplate.txt");

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            String number_of_facilitators = (String) jsonObject.get("number_of_facilitators");
            String number_of_students = (String) jsonObject.get("number_of_students");
            String number_of_partners = (String) jsonObject.get("number_of_partners");

            JSONArray tasks= (JSONArray) jsonObject.get("tasks");

            for (int i =0; i<tasks.size(); i++){

                JSONObject task = (JSONObject) tasks.get(i);

                String task_title = (String) task.get("title");
                String task_description = (String) task.get("description");

                System.out.println(task_title);
                System.out.println(task_description);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch ( org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }
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
        return new Project[0];
    }

    @Override
    public Project[] getProjectsOf(String s) {
        return new Project[0];
    }

    @Override
    public int getNumberOfProjects() {
        return 0;
    }

    @Override
    public LocalDate getEnd() {
        return null;
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
    public Edition listEvent() {
        for (Event event : events) {
            event.toString();
        }
        return this;
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

