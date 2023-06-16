package CBL;

import Interfaces.Event;
import Interfaces.EventController;
import enumerations.EventType;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;


public class EditionImp implements Edition, EventController {
    private static int SIZE = 10;
    private final int FACTOR = 2;
    private String name;
    private LocalDate start;
    private LocalDate end;
    private String projectTemplate;
    private Status status;
    private Project[] projects;
    private int numberOfProjects;
    private int numberOfEvents;
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
    }

    @Override
    public void removeProject(String s) {
    }

    @Override
    public Project getProject(String s) {
        return this.projects[0];
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

    /**
     * @param event
     */
    @Override
    public void addEvent(Event event) throws IllegalArgumentException {
        if (event == null) {
            throw new IllegalArgumentException("Event is null");
        }
        try {
            hasEvent(event);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        if (numberOfEvents == this.events.length)
            expandEvents();

        if (event.getType() == EventType.KICKOFF)


            this.events[numberOfEvents] = event;
        this.numberOfEvents++;
    }

    /**
     * @return
     */
    @Override
    public boolean removeEvent(Event event) {
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
    public Event updateEvent(Event event, String location, LocalDate startDate, LocalDate endDate) throws IllegalArgumentException {
        if (event == null) {
            throw new IllegalArgumentException("Event is null");
        }
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
}

