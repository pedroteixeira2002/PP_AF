package Menus;

import Interfaces.MenuDisplay;
import cbl.PortfolioImp;

import java.io.IOException;

public class MenuStartManagement implements MenuDisplay {
    @Override
    public void display() {
        System.out.println("Welcome to the Start Management Menu");
        System.out.println("1 - Edition Manager");
        System.out.println("2 - Project Manager");
        System.out.println("3 - Participant Management");
        System.out.println("0 - Exit");
    }

    public static void handleStartMenu(MenuManager menuManager, PortfolioImp portfolio) throws IOException {

        MenuStartManagement menuStart = new MenuStartManagement();
        boolean isStartManagementRunning = true;

        while (isStartManagementRunning) {

            menuManager.displayMenu(menuStart);

            int option;

            try {
                option = menuManager.getOption();
            } catch (Exception e) {
                option = -1;
            }

            switch (option) {
                case 1:
                    EditionManagerMenu.handleEditionManagerMenu(menuManager, portfolio);
                    break;
                case 2:
                    try {
                        System.out.println("Enter the name of the edition you want to manage the projects");
                        ProjectManagerMenu.handleProjectManagerMenu(menuManager,.getEdition(UserInput.getString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    ParticipantManagerMenu.handleParticipantManagerMenu(menuManager);
                    break;
                case 0:
                    isStartManagementRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
