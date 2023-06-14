package CBL;

import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;


public class EditionImp implements Edition {

    private static int SIZE = 10;
    private final int FATOR = 2;
    private String name;
    private LocalDate start;
    private LocalDate end;
    private String projectTemplate;
    private Status status;
    private Project[] projects;
    private int numberOfProjects;

    public EditionImp(String name, LocalDate start, LocalDate end, String projectTemplate, Status status, Project[] projects, int numberOfProjects) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.projectTemplate = projectTemplate;
        this.status = status.INACTIVE;
        this.projects = new Project[SIZE];
        this.numberOfProjects = numberOfProjects;
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
}
