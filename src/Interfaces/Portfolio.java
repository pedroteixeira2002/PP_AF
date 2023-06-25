package Interfaces;

import cbl.EditionImp;
import exceptions.SubmissionsUpToDate;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;

public interface Portfolio {
    int getNumberOfEditions();

    Edition allMissingSubmissions() throws SubmissionsUpToDate;

    Project missingSubmissions(Edition edition) throws SubmissionsUpToDate;

    void hasEdition(Edition edition) throws IllegalArgumentException;
    public Edition getEdition(String name);

}
