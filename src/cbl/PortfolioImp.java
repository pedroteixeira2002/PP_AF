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

import Interfaces.EditionsController;
import Interfaces.Portfolio;
import exceptions.SubmissionsUpToDate;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import ma02_resources.project.Task;

/**
 * This class represents a portfolio
 */
public class PortfolioImp implements Portfolio, EditionsController {
    private static int SIZE = 10;
    private Edition[] editions;
    private int numberOfEditions;

    public PortfolioImp() {
        this.editions = new EditionImp[SIZE];
        this.numberOfEditions = 0;
    }

    /**
     * Prints the editions in the portfolio
     */
    @Override
    public EditionImp[] getEditions() {
        return (EditionImp[]) editions;
    }

    /**
     * @return the number of editions in the portfolio
     */
    public int getNumberOfEditions() {
        return numberOfEditions;
    }

    /**
     * @param edition throws IllegalArgumentException
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
     * this method checks if the edition already exists
     * @param edition the edition to be checked
     * @throws IllegalArgumentException if the edition already exists
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

    /**
     * this method gets the index of the edition
     * @param edition the edition to be checked
     * @return the index of the edition
     */
    public int getIndex(Edition edition) {
        for (int i = 0; i < editions.length; i++) {
            if (editions[i] == edition)
                return i;
        }
        return -1;
    }

    /**
     * this method removes the edition
     * @param name the name of the edition to be removed
     * @return true if the edition was removed
     */
    @Override
    public boolean removeEdition(String name) {
        Edition that = getEdition(name);
        int index = getIndex(that);
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
     * this method set the status of the edition to active or inactive
     * @param name the name of the edition
     */
    public void setStatusActive(String name) {
        Edition that = getEdition(name);

        for (Edition edition : editions) {
            if (edition.equals(that)) {
                edition.setStatus(Status.ACTIVE);
            } else {
                edition.setStatus(Status.INACTIVE);
            }
        }
    }

    /**
     * this method gets the edition
     * @param edition the edition to be checked
     * @return the edition
     */
    @Override
    public Edition getEdition(Edition edition) {
        return editions[getIndex(edition)];
    }

    /**
     * this method gets the edition
     * @param name the name of the edition
     * @return the edition
     */
    public Edition getEdition(String name) {
        for (Edition edition : editions) {
            if (edition.getName().equals(name)) {
                return edition;
            }
        }
        return null;
    }

    /**
     * this methhod lists the editions
     */
    public void listEditions() {
        for (Edition edition : editions) {
            System.out.println(edition.toString());
        }
    }

    /**
     * this method checks the all missing submissions
     * @return the edition
     * @throws SubmissionsUpToDate if all submissions are up-to-date
     */
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

    /**
     * this method checks the missing submissions
     * @param edition the edition to be checked
     * @return the project
     * @throws SubmissionsUpToDate if all submissions are up-to-date
     */
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
