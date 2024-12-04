package org.example;

import java.util.ArrayList;
import java.util.List;

public class ZooAction {


    private ConsoleMenu consoleMenu;

    public ZooAction() {
        this.consoleMenu = new ConsoleMenu();
    }

    public void start() {
        boolean boucle = true;
        while (boucle) {

            String chiffre = consoleMenu.chiffreChoix();

            switch (chiffre) {
                case "1":
                    consoleMenu.addAnimal();
                    break;
                case "2":
                    consoleMenu.listAnimal();
                    break;
                case "3":
                    consoleMenu.deplacerAnimal();
                    break;
                case "4":
                    consoleMenu.nourrirAnimal();
                    break;
                case "5":
                    consoleMenu.bye();
                    boucle = false;
                    break;
                default:
                    consoleMenu.erreur();
            }
        }
    }

}
