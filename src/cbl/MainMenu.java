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
import application.ReadJSON;
import ma02_resources.project.Project;
import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;

import java.io.IOException;

/**
 * This class represents the main menu
 */
public class MainMenu {
    public static void main(String[] args) throws ParticipantAlreadyInProject, IllegalNumberOfParticipantType, IOException {

        MenuManager menuManager = new MenuManager();
        Portfolio portfolio = new PortfolioImp();
        ProjectImp project = new ProjectImp();

        ReadJSON.getInstance().readJSON("json_files//test.json");

        try {
            MenuStartManagement.handleStartMenu(menuManager, (PortfolioImp) portfolio, project);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
