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

import java.util.Scanner;

/**
 * this class is responsible for managing the menus
 */
public class MenuManager {

    private static final int MAX_SIZE = 100;
    private int currentOption = 0;
    private MenuDisplay[] menuList;
    private int lastOption = currentOption -1;

    /**
     * this method is responsible for getting the option chosen by the user
     * @return the option chosen by the user
     */
    public int getOption() {
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        currentOption++;
        return option;
    }

    /**
     * this method is responsible for displaying the menu
     * @param
     */
    public MenuManager(){
        menuList = new MenuDisplay[MAX_SIZE];
    }

    /**
     * this method is responsible for displaying the menu
     * @param menu the menu to display
     */
    public void displayMenu(MenuDisplay menu) {
        if (lastOption < MAX_SIZE - 1) {
            menuList[currentOption++] = menu;
            menu.display();
        } else {
            System.out.println("Menu is full");
        }
    }

    /**
     * this method is responsible for going back to the previous menu
     */
    public void goBack(){
        if (lastOption >=0) {
            MenuDisplay previousMenu = menuList[lastOption];
            previousMenu.display();
        } else {
            System.out.println("No previous menu. Exiting...");
            System.exit(0);
        }
    }

}
