/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package Menus;


import Interfaces.MenuDisplay;
import Interfaces.Portfolio;
import cbl.ProjectImp;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;

import java.io.IOException;

import static Menus.ParticipantManagerMenu.readParticipant;

/**
 * This class represents the Project Manager Menu
 */
public class ProjectManagerMenu implements MenuDisplay {
    @Override
    public void display() {
        System.out.println("Welcome to the Project Manager Menu");
        System.out.println("1 - Add Participant to Project");
        System.out.println("2 - Remove Participant from Project");
        System.out.println("3 - Add Tag to Project");
        System.out.println("4 - Remove Tag to Project");
        System.out.println("5 - Add Task to Project");
        System.out.println("6 - List Projects");
        System.out.println("7 - List Projects by Tag");
        System.out.println("8 - List Projects by Participant");
        System.out.println("0 - Exit");
    }

    /**
     * This method adds a participant to a project
     *
     * @param edition the edition to add the participant to
     * @throws IOException if an error occurs while reading the participant
     */
    public static void handleProjectManagerMenu(MenuManager menuManager, Edition edition) throws IOException {

        ProjectManagerMenu projectManager = new ProjectManagerMenu();
        boolean isProjectRunning = true;

        while (isProjectRunning) {

            menuManager.displayMenu(projectManager);

            int option;

            try {
                option = menuManager.getOption();
            } catch (Exception e) {
                option = -1;
            }

            switch (option) {
                case 1:
                    System.out.println("Enter the name of the project you want to add a participant to");
                    String name = UserInput.getString();
                    ProjectImp project = (ProjectImp) edition.getProject(name);
                    projectManager.addParticipant(edition);
                    break;
                case 2:
                    projectManager.removeParticipant(edition);
                    break;
                case 3:
                    projectManager.addTag(edition);
                    break;
                case 4:
                    projectManager.removeTag(edition);
                    break;
                case 5:
                    projectManager.addTask(edition);
                    break;
                case 6:
                    edition.getProjects();
                    break;
                case 7:
                    try {
                        System.out.println("Enter the tag you want to list projects by");
                        edition.getProjectsByTag(UserInput.getString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        System.out.println("Enter the name of the participant you want to list projects by");
                        edition.getProjectsOf(UserInput.getString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    isProjectRunning = false;
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }

    }

    /**
     * This method adds a task to a project
     * @param edition the edition to add the task to
     */
    private void removeParticipant(Edition edition) {

        String participantEmail, projectName;

        try {
            System.out.println("Enter the name of the project you want to remove a participant from");
            projectName = UserInput.getString();

            System.out.println("Enter the email of the participant you want to remove from the project");
            participantEmail = UserInput.getString();

            edition.getProject(projectName).removeParticipant(participantEmail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * This method adds a participant to a project
     * @param edition the edition to add the participant to
     */
    private void addParticipant(Edition edition){
        String participantEmail, projectName;

        try {
            System.out.println("Enter the name of the project you want to add a participant to");
            projectName = UserInput.getString();

            System.out.println("Enter the email of the participant you want to add to the project");
            participantEmail = UserInput.getString();

            edition.getProject(projectName).addParticipant(readParticipant());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method adds a tag to a project
     * @param edition the edition to add the tag to
     */
    private void addTag(Edition edition) {

        String tag, projectName;

        try {
            System.out.println("Enter the name of the project you want to add a tag to");
            projectName = UserInput.getString();

            System.out.println("Enter the tag you want to add to the project");
            tag = UserInput.getString();

            ((ProjectImp) edition.getProject(projectName)).addTag(tag);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method removes a tag from a project
     * @param edition the edition to remove the tag from
     */
    private void removeTag(Edition edition) {

        String tag, projectName;

        try {
            System.out.println("Enter the name of the project you want to remove a tag from");
            projectName = UserInput.getString();

            System.out.println("Enter the tag you want to remove from the project");
            tag = UserInput.getString();

            ((ProjectImp) edition.getProject(projectName)).removeTag(tag);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method adds a task to a project
     * @param edition the edition to add the task to
     */
    private void addTask(Edition edition) {

        String projectName;

        try {
            System.out.println("Enter the name of the project you want to add a task to");
            projectName = UserInput.getString();

            edition.getProject(projectName).addTask(UserInput.getTask());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
