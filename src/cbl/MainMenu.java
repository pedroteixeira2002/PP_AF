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


import Interfaces.Portfolio;
import Menus.MenuManager;
import Menus.MenuStartManagement;
import ma02_resources.project.Project;
import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;

import java.io.IOException;

public class MainMenu {
    public static void main(String[] args) throws ParticipantAlreadyInProject, IllegalNumberOfParticipantType, IOException {

        MenuManager menuManager = new MenuManager();
        PortfolioImp portfolio = new PortfolioImp();
        ProjectImp project = new ProjectImp();

        try {
            MenuStartManagement.handleStartMenu(menuManager, portfolio, project);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
