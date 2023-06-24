package Menus;

import CBL.EditionImp;
import CBL.Manager;
import Interfaces.MenuDisplay;
import Participants.StudentImp;
import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Submission;
import ma02_resources.project.Task;


public class ProjectManagerMenu implements MenuDisplay {
    @Override
    public void display() {
        System.out.println("Welcome to the Project Manager Menu");
        System.out.println("1 - Add Participant to Project");
        System.out.println("2 - Remove Participant from Project");
        System.out.println("3 - Add Submission to Project");
        System.out.println("4 - Add Tag to Project");
        System.out.println("5 - Remove Tag to Project");
        System.out.println("6 - Add Task to Project");
        System.out.println("7 - List Projects");
        System.out.println("8 - List Projects by Tag");
        System.out.println("9 - List Projects by Participant");
        System.out.println("10 - List Participants by Institution");
        System.out.println("11 - List Participants by City");
        System.out.println("0 - Exit");
    }

    public static void handleProjectManagerMenu(MenuManager menuManager, Manager manager, Edition edition, Task task, Submission submission){

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
                    projectManager.addParticipant(manager, edition);
                    break;
                case 2:
                    projectManager.removeParticipant(manager, edition);
                    break;
                case 3:
                    projectManager.addSubmission(task, edition);
                    break;
                case 4:
                    projectManager.addTag(edition);
                    break;
                case 5:
                    projectManager.removeTag(edition);
                    break;
                case 6:
                    projectManager.addTask(edition);
                    break;
                case 7:
                    //listProjects();
                    break;
                case 8:
                    //listProjectsByTag();
                    break;
                case 9:
                    //listProjectsByParticipant();
                    break;
                case 10:
                    //listParticipantsByInstitution();
                    break;
                case 11:
                    //listParticipantsByCity();
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

    private void addTask(Edition edition) {

        String projectName;

        try{
            System.out.println("Enter the name of the project you want to add a task to");
            projectName = UserInput.getString();

            edition.getProject(projectName).addTask(UserInput.getTask());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void removeTag(Edition edition) {

        String tag, projectName;

        try{
            System.out.println("Enter the name of the project you want to remove a tag from");
            projectName = UserInput.getString();

            System.out.println("Enter the tag you want to remove from the project");
            tag = UserInput.getString();

            edition.getProject(projectName).removeTag(tag);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void addTag(Edition edition) {

        String tag, projectName;

        try{
            System.out.println("Enter the name of the project you want to add a tag to");
            projectName = UserInput.getString();

            System.out.println("Enter the tag you want to add to the project");
            tag = UserInput.getString();

            edition.getProject(projectName).addTag(tag);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void addSubmission(Task task, Edition edition){

        String projectName, taskTitle, taskDescription, studentEmail;

        try {
            System.out.println("Enter the name of the project you want to add a submission to");
            projectName = UserInput.getString();

            System.out.println("Enter the email of the student who made the submission");
            studentEmail = UserInput.getString();

            System.out.println("Enter the title of the task");
            taskTitle = UserInput.getString();

            System.out.println("Enter the description of the task");
            taskDescription = UserInput.getString();

            task.addSubmission();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    private void addParticipant(Manager manager, Edition edition) {

        String participantEmail, projectName;

        try {
            System.out.println("Enter the name of the project you want to add a participant to");
            projectName = UserInput.getString();

            System.out.println("Enter the email of the participant you want to add to the project");
            participantEmail = UserInput.getString();

            edition.getProject(projectName).addParticipant(manager.getParticipant(participantEmail));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeParticipant(Manager manager, Edition edition) {

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


}