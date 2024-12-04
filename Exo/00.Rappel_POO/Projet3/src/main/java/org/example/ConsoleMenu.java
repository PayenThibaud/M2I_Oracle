package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    private Scanner sc;
    private int id;

    public ConsoleMenu() {
        this.sc = new Scanner(System.in);
        this.id = id++;
    }

    Enclosure enclosure1 = new Enclosure(1, "Enclo1", new ArrayList<Animal>());
    Enclosure enclosure2 = new Enclosure(2, "Enclo2", new ArrayList<Animal>());
    Enclosure enclosure3 = new Enclosure(3, "Enclo3", new ArrayList<Animal>());

    public String chiffreChoix() {

        System.out.println("=Menu Zoo=");
        System.out.println("1. ajouter un animal");
        System.out.println("2. lister les animaux");
        System.out.println("3. deplacer un animal");
        System.out.println("4. Nourrir les animaux");
        System.out.println("5. quitter");

        System.out.print("choix : ");

        String userInput = sc.nextLine();
        return userInput;
    }


    public void erreur() {
        System.out.println("erreur : 1 / 2 / 3 / 4 / 5");
    }

    public void bye() {
        System.out.println("bye");
    }

    public void addAnimal() {


        System.out.println("= creation d un animal = ");

        System.out.println("nom : ");
        String name = sc.nextLine();


        System.out.println("espece : ");
        String species = sc.nextLine();

        Animal animal = null;

        boolean boucleAnimal = true;
        while (boucleAnimal) {

            System.out.print("L animal est un : ");
            System.out.print("1. oiseau ");
            System.out.print("2. mammifere ");

            String animalChiffre = sc.nextLine();
            boolean birdFly = false;
            boolean mammalHerbi = false;

            switch (animalChiffre) {

                case "1":
                    System.out.print("Es ce que l oiseau vole ? y ");
                    String isFlying = sc.nextLine();
                    if (isFlying.equals("y")) {
                        birdFly = true;
                    }
                    animal = new Bird(id, name, species, birdFly);
                    boucleAnimal = false;
                    break;

                case "2":
                    System.out.print("Es ce que le mammifere est herbivore ? y ");
                    String isHerbi = sc.nextLine();
                    if (isHerbi.equals("y")) {
                        mammalHerbi = true;
                    }
                    animal = new Mammal(id, name, species, mammalHerbi);
                    boucleAnimal = false;
                    break;

                default:
                    System.out.println("ERREUR 1/2");
                    break;
            }
        }


        System.out.println("Dans qu elle enclo : ");
        System.out.println("1 , 2 , 3");
        boolean boucleEnclo = true;
        while (boucleEnclo) {

            String encloChiffre = sc.nextLine();

            switch (encloChiffre) {

                case "1":
                    enclosure1.addAnimal(animal);
                    System.out.println("L animal : " + animal.name + " est dans l enclo : " + enclosure1.getName());
                    boucleEnclo = false;
                    break;

                case "2":
                    enclosure2.addAnimal(animal);
                    System.out.println("L animal : " + animal.name + " est dans l enclo : " + enclosure2.getName());
                    boucleEnclo = false;
                    break;

                case "3":
                    enclosure3.addAnimal(animal);
                    System.out.println("L animal : " + animal.name + " est dans l enclo : " + enclosure3.getName());
                    boucleEnclo = false;
                    break;

                default:
                    System.out.println("ERREUR 1/2");

                    break;
            }
        }
    }


    public void listAnimal() {
        System.out.println("= liste un animal =");
        System.out.println("= Enclo 1 =");
        enclosure1.getAllAnimal();
        System.out.println("= Enclo 2 =");
        enclosure2.getAllAnimal();
        System.out.println("= Enclo 3 =");
        enclosure3.getAllAnimal();
    }

    public void deplacerAnimal() {
    }

    public void nourrirAnimal() {
    }


}
