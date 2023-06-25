package Menus;

import Interfaces.MenuDisplay;
import cbl.EditionImp;
import cbl.PortfolioImp;
import ma02_resources.project.Edition;
import ma02_resources.project.Status;

import java.io.IOException;
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

    public static void handleEditionManagerMenu(MenuManager menuManager, PortfolioImp portfolio) throws IOException {

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
                        portfolio.addEdition(readEdition());
                        System.out.println("Edition created successfully");
                    } catch (Exception e) {
                        System.out.println("Edition creation failed");
                    }
                    break;
                case 2:
                    portfolio.removeEdition(UserInput.getString());
                    break;
                case 3:
                    portfolio.listEditions();
                    break;
                case 4:
                    try {
                        System.out.println("Enter the name of the edition you want to set as active");
                        portfolio.setStatusActive(UserInput.getString());
                        System.out.println("Edition set as active");
                    } catch (Exception e) {
                        System.out.println("Edition status change failed");
                    }
                    break;


                case 5:
                    //create new project for an edition
                    String projectName1;
                    String projectDescription;
                    String[] tags = new String[10];

                    try {
                        System.out.println("Enter the name of the edition you want to add a project to");
                        editionName = UserInput.getString();
                        Edition that = portfolio.getEdition(editionName);


                        do {
                            System.out.println("Enter the name of the project");
                            try {
                                projectName1 = UserInput.getString();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                projectName1 = null;
                            }
                        } while (projectName1 == null);

                        do {
                            System.out.println("Enter the description of the project");
                            try {
                                projectDescription = UserInput.getString();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                projectDescription = null;
                            }
                        } while (projectDescription == null);

                        int i = 0;
                        do {

                            System.out.println("Enter the tags of the project");
                            try {
                                tags[i] = UserInput.getString();
                                i++;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                tags = null;
                            }
                        } while (tags == null);


                        that.addProject(projectName1, projectDescription, tags);
                        System.out.println("Project added successfully");

                    } catch (Exception e) {
                        System.out.println("Project creation failed");
                    }

                    break;
                case 6:
                    try {
                        System.out.println("Enter the name of the edition you want to remove a project from");
                        editionName = UserInput.getString();
                        Edition that = portfolio.getEdition(editionName);
                        System.out.println("Enter the name of the project you want to remove");
                        projectName = UserInput.getString();
                        that.removeProject(projectName);
                        System.out.println("Project removed successfully");
                    } catch (Exception e) {
                        System.out.println("Project removal failed");
                    }
                    break;
                case 7:
                    //check edition progress
                    try {
                        System.out.println("Enter the name of the edition you want to check the progress of");
                        EditionImp that = (EditionImp) portfolio.getEdition(UserInput.getString());
                        that.getProgress();
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

    public static Edition readEdition() {

        String editionName;
        LocalDate start;
        LocalDate end;
        Status status;

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
<<<<<<< Updated upstream
            System.out.println("Enter the status of the edition: Active, Inactive, Closed, Unknown, Canceled");
=======
            System.out.println("Enter the status of the edition");
>>>>>>> Stashed changes
            try {
                status = UserInput.getStatus();
            } catch (Exception e) {
                status = null;
            }
        } while (status == null);

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
        do {
            System.out.println("Enter the end date of the edition");
            try {
                end = UserInput.getLocalDate();
            } catch (Exception e) {
                end = null;
            }
        } while (end == null);

        return new EditionImp(editionName, start, end, Status.INACTIVE);
    }
<<<<<<< Updated upstream
=======

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
        String[] tags = new String[10];

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
            System.out.println("Enter the tags of the project");
            try {
                tags = UserInput.getTags();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                tags = null;
            }
        } while (tags == null);


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

>>>>>>> Stashed changes
}
