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
import cbl.EditionImp;
import cbl.PortfolioImp;
import cbl.ProjectImp;
import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;

import java.io.IOException;

/**
 * Class responsible for displaying the Start Management Menu
 */
public class MenuStartManagement implements MenuDisplay {
    @Override
    public void display() {
        System.out.println("Welcome to the Start Management Menu");
        System.out.println("1 - Edition Manager");
        System.out.println("2 - Project Manager");
        System.out.println("3 - Participant Management");
        System.out.println("0 - Exit");
    }

    /**
     * Method responsible for handling the Start Management Menu
     * @param menuManager the menu manager
     * @param portfolio the portfolio
     * @param project the project
     * @throws IOException if an error occurs while reading the input
     * @throws ParticipantAlreadyInProject if the participant is already in the project
     * @throws IllegalNumberOfParticipantType if the number of participants is illegal
     */
    public static void handleStartMenu(MenuManager menuManager, PortfolioImp portfolio, ProjectImp project) throws IOException, ParticipantAlreadyInProject, IllegalNumberOfParticipantType {

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
                        ProjectManagerMenu.handleProjectManagerMenu(menuManager,portfolio.getEdition(UserInput.getString()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    ParticipantManagerMenu.handleParticipantManagerMenu(menuManager,project);
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
