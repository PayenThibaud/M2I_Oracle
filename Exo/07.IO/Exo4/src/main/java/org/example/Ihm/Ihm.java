package org.example.Ihm;

import org.example.Entity.Character;
import org.example.Jeu.Jeu;

import java.util.Scanner;

public class Ihm {
    public void start() {
        Jeu jeu = new Jeu();
        Scanner scanner = new Scanner(System.in);
        Character character;

        while (true) {
            System.out.println("--- Bienvenue dans le jeu d'aventure textuelle ! ---");
            System.out.println(" 1. Créer un nouveau personnage");
            System.out.println(" 2. Charger un personnage existant");
            System.out.println(" 3. Quitter");
            System.out.println(" Choisissez une option :");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    jeu.creationCharacter(scanner);
                    break;
                case 2:
                    jeu.partirAventure(scanner);
                    break;
                case 3:

                    System.out.println("bye bye");
                    return;
                default:
                    System.out.println("réessaye.");
            }
        }
    }
}
