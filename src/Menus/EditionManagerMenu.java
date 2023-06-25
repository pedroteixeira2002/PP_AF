package Menus;

import Interfaces.MenuDisplay;
import cbl.EditionImp;
import cbl.Manager;
import ma02_resources.project.Edition;

import java.time.LocalDate;

public class EditionManagerMenu implements MenuDisplay {
    @Override
    public void display() {
        System.out.println("Welcome to the Edition Manager Menu");
        System.out.println("1 - Create Edition");
        System.out.println("2 - Remove Edition");
        System.out.println("3 - List Editions");
        System.out.println("4 - Set Edition as Active");
        System.out.println("5 - Create new Project for Edition");
        System.out.println("6 - Remove project from Edition");
        System.out.println("7 - Check Edition progress");
        System.out.println("0 - Exit");
    }

    public static void handleEditionManagerMenu(MenuManager menuManager, Manager manager) {

        EditionManagerMenu editionManager = new EditionManagerMenu();
        boolean isEditionRunning = true;

        String editionName;
        String projectName;

        while (isEditionRunning) {

            menuManager.displayMenu(editionManager);

            int option;

            try {
                option = menuManager.getOption();
            } catch (Exception e) {
                option = -1;
            }

            switch (option) {
                case 1:
                    try {
                        manager.addEdition(editionManager.createEdition(manager));
                        System.out.println("Edition created successfully");
                    } catch (Exception e) {
                        System.out.println("Edition creation failed");
                    }
                    break;
                case 2:
                    editionManager.removeEdition(manager);
                    break;
                case 3:
                    manager.listEditions();
                    break;
                case 4:
                    try {
                        System.out.println("Enter the name of the edition you want to set as active");
                        manager.setStatusActive(manager.getEdition(UserInput.getString()));
                        System.out.println("Edition set as active");
                    } catch (Exception e) {
                        System.out.println("Edition status change failed");
                    }
                    break;
                case 5:
                    editionManager.createProject(manager);
                    break;
                case 6:
                    editionManager.removeProject(manager);
                    break;
                case 7:
                    try {
                        System.out.println("Enter the name of the edition you want to check the progress of");
                        manager.checkEditionProgress(manager.getEdition(UserInput.getString()));
                        System.out.println("Edition progress checked");
                    } catch (Exception e) {
                        System.out.println("Edition progress check failed");
                    }
                    break;
                    case 0:
                    isEditionRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }

    }

    public Edition createEdition(Manager manager) {

        String editionName;
        LocalDate start;
        LocalDate end;

        do {
            System.out.println("Enter the name of the edition");
            try {
                editionName = UserInput.getString();
            } catch (Exception e) {
                editionName = null;
            }
        } while (editionName == null);

        do {
            System.out.println("Enter the start date of the edition");
            try {
                start = UserInput.getLocalDate();
            } catch (Exception e) {
                start = null;
            }
        } while (start == null);

        do {
            System.out.println("Enter the end date of the edition");
            try {
                end = UserInput.getLocalDate();
            } catch (Exception e) {
                end = null;
            }
        } while (end == null);

        Edition edition = new EditionImp(editionName, start, end, status.INACTIVE);
        return edition;
    }

    public void removeEdition(Manager manager) {
        UserInput input = new UserInput();

        try {
            System.out.println("Enter the name of the edition you want to remove");
            manager.removeEdition(input.getString());
        } catch (Exception e) {
            System.out.println("Edition removal failed");
        }
    }

    public void createProject(Manager manager) {

        String projectName;
        String projectDescription;
        String editionName;
        String[] tags = new String[1];

        do {
            System.out.println("Enter the name of the project");
            try {
                projectName = UserInput.getString();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                projectName = null;
            }
        } while (projectName == null);

        do {
            System.out.println("Enter the description of the project");
            try {
                projectDescription = UserInput.getString();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                projectDescription = null;
            }
        } while (projectDescription == null);

        do {
            System.out.println("Enter the name of the edition that the project belongs to");
            try {
                editionName = UserInput.getString();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                editionName = null;
            }
        } while (editionName == null);

        try {
            manager.getEdition(editionName).addProject(projectName, projectDescription, tags);
            System.out.println("Project created successfully");
        } catch (Exception e) {
            System.out.println("Project creation failed");

        }

    }

    public void removeProject(Manager manager) {

        String editionName;
        String projectName;

        do {
            System.out.println("Enter the name of the edition you wish to remove the project from");
            try {
                editionName = UserInput.getString();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                editionName = null;
            }
        } while (editionName == null);

        do {
            System.out.println("Enter the name of the project you wish to remove");
            try {
                projectName = UserInput.getString();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                projectName = null;
            }
        } while (projectName == null);

        try {
            manager.getEdition(editionName).removeProject(projectName);
            System.out.println("Project removed successfully");
        } catch (Exception e) {
            System.out.println("Project removal failed");
        }

    }

}
