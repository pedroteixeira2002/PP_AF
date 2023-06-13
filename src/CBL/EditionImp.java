package CBL;

import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

public class EditionImp implements Edition {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public LocalDate getStart() {
        return null;
    }

    @Override
    public String getProjectTemplate() {
        return null;
    }

    @Override
    public Status getStatus() {
        return null;
    }

    @Override
    public void setStatus(Status status) {

    }

    @Override
    public void addProject(String s, String s1, String[] strings) throws IOException, ParseException {

    }

    @Override
    public void removeProject(String s) {

    }

    @Override
    public Project getProject(String s) {
        return null;
    }

    @Override
    public Project[] getProjects() {
        return new Project[0];
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
