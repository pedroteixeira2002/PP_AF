package cbl;

import Interfaces.EditionsController;
import Interfaces.Portfolio;
import exceptions.SubmissionsUpToDate;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import ma02_resources.project.Task;


public class PortfolioImp implements Portfolio, EditionsController {
    private static int SIZE = 10;
    private Edition[] editions;
    private int numberOfEditions;

    public PortfolioImp(int numberOfEditions) {
        this.editions = new Edition[SIZE];
        this.numberOfEditions = numberOfEditions;
    }

    /**
     * Prints the editions in the portfolio
     */
    public void getEditions() {
        for (Edition edition : this.editions) {
            edition.toString();
        }
    }


    /**
     * @return the number of editions in the portfolio
     */
    public int getNumberOfEditions() {
        return numberOfEditions;
    }


    /**
     * @param edition
     * throws IllegalArgumentException
     */
    @Override
    public void addEdition(Edition edition) throws IllegalArgumentException {
        try {
            hasEdition(edition);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        if (edition.getStatus() == Status.ACTIVE) {
            for (Edition edition1 : this.editions) {
                if (edition1.getStatus() == Status.ACTIVE) {
                    edition1.setStatus(Status.CLOSED);
                }
            }
        }
        this.editions[numberOfEditions] = edition;
        this.numberOfEditions++;
    }

    /**
     * @param edition
     * @throws IllegalArgumentException
     */
    @Override
    public void hasEdition(Edition edition) throws IllegalArgumentException {
        if (edition == null) {
            throw new IllegalArgumentException("Edition is null");
        }
        for (Edition edition1 : this.editions) {
            if (edition1.equals(edition)) {
                throw new IllegalArgumentException("Edition already exists");
            }
        }

    }

    public int getIndex(Edition edition) {
        for (int i = 0; i < editions.length; i++) {
            if (editions[i] == edition)
                return i;
        }
        return -1;
    }

    /**
     * @param edition
     * @return
     */
    @Override
    public boolean removeEdition(Edition edition) {
        int index = getIndex(edition);
        if (index != -1) {
            throw new IllegalArgumentException("Edition does not exist");
        }
        editions[index] = null;

        for (int i = index; i < numberOfEditions - 1; i++) {
            editions[i] = editions[i + 1];
        }
        this.numberOfEditions--;

        return true;
    }

    /**
     * @param edition
     * @return
     */
    @Override
    public Edition getEdition(Edition edition) {
        return editions[getIndex(edition)];
    }

    @Override
    public Edition allMissingSubmissions() throws SubmissionsUpToDate {
        for (Edition edition : this.editions) {
            for (Project project : edition.getProjects()) {
                for (Task task : project.getTasks()) {
                    if (task.getNumberOfSubmissions() != project.getNumberOfStudents()) {
                        return edition;
                    }
                }
            }
        }
        throw new SubmissionsUpToDate("All submissions are up to date");
    }

    @Override
    public Project missingSubmissions(Edition edition) throws SubmissionsUpToDate {
        if (edition == null) {
            throw new IllegalArgumentException("Edition is null");
        }
        for (Project project : edition.getProjects()) {
            for (Task task : project.getTasks()) {
                if (task.getNumberOfSubmissions() != project.getNumberOfStudents()) {
                    project.toString();
                }
            }
            System.out.println("All submissions are up to date in the selected Edition");
        }
        for (Edition edition1 : this.editions) {
            if (edition1.getStatus() == Status.ACTIVE) {
                for (Project project : edition1.getProjects()) {
                    for (Task task : project.getTasks()) {
                        if (task.getNumberOfSubmissions() != project.getNumberOfStudents()) {
                            return project;
                        }
                    }
                }
            }
        }
        throw new SubmissionsUpToDate("All submissions are up to date in the selected Edition and in the active one");
    }
}
