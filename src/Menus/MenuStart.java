package Menus;

import Interfaces.MenuDisplay;

public class MenuStart implements MenuDisplay {

    @Override
    public void display() {
        System.out.println("Welcome to the application.Main Menu");
        System.out.println("1 - Edition Manager");
        System.out.println("2 - Project Manager");
        System.out.println("3 - Event Manager");
        System.out.println("4 - Participant Manager");
        System.out.println("5 - Exit");
    }

    public void navigateStartMenu(MenuManager menuManager) {
        MenuStart menuStart = new MenuStart();
        boolean isRunning = true;

        while (isRunning) {
            menuManager.displayMenu(menuStart);

            int option;

            try {
                option = menuManager.getOption();
            } catch (Exception e) {
                option = -1;
            }

            switch (option) {
                case 1: // Edition Manager
                    EditionManagerMenu.navigateEditionManagerMenu(menuManager);
                    break;
                case 2:
                    try {
                        System.out.println("Enter the name of the Edition you want to manage the projects");
                        //ProjectManagerMenu.navigateProjectManagerMenu(menuManager, manager, manager.getEditionByName(menuManager.getOption()));
                    } catch (Exception e) {
                        System.out.println("e.getMessage()");
                    }
                    break;
                case 3:
                    EventManagerMenu.navigateEventManagerMenu(menuManager);
                    break;
                case 4:
                    ParticipantManagerMenu.navigateParticipantManagerMenu(menuManager);
                    break;
                case 0:
                    isRunning = false;
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
