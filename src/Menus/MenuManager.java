package Menus;

import Interfaces.MenuDisplay;

import java.util.Scanner;

public class MenuManager {

    private static final int MAX_SIZE = 100;
    private int currentOption = 0;
    private MenuDisplay[] menuList;
    private int lastOption = currentOption--;

    public int getOption() {
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        currentOption++;
        return option;
    }

    public MenuManager(){
        menuList = new MenuDisplay[MAX_SIZE];
    }

    public void displayMenu(MenuDisplay menu) {
        if (lastOption < MAX_SIZE - 1) {
            menuList[currentOption++] = menu;
            menu.display();
        } else {
            System.out.println("Menu is full");
        }
    }

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
