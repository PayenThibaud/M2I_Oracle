package org.example.Jeu;

import org.example.Entity.Character;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {

    private List<org.example.Entity.Character> characters;

    public Jeu() {
        characters = new ArrayList<org.example.Entity.Character>();
        loadListCharacters();
    }

    private void loadListCharacters() {
        File file = new File("characters.dat");

        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                characters = (List<Character>) in.readObject();
                System.out.println("Liste de characters charger");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erreur lors du chargement : " + e.getMessage());
            }
        }
    }


    public void creationCharacter(Scanner scanner) {
        System.out.println("Entrez le nom de votre héros :");
        String nom = scanner.nextLine();

        System.out.println("Entrez la force :");
        int force = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Entrez la santé :");
        int pv = scanner.nextInt();
        scanner.nextLine();

        org.example.Entity.Character character = new org.example.Entity.Character(nom, force, pv);
        characters.add(character);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("characters.dat"))) {
            out.writeObject(characters);
            System.out.println("Personnage créé avec succès et sauvegardé.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    ;

    public Character choisirCharacters(Scanner scanner) {

        Character personnageChoisi = null;

        if (characters.isEmpty()) {
            System.out.println("Redirection sur la creation des personnages");
            creationCharacter(scanner);
        } else {
            System.out.println("\nListe des personnages :");
            for (Character character : characters) {
                System.out.println(character);
            }

            System.out.println("\nEntrez le nom du personnage choisi :");
            String nomRecherche = scanner.nextLine();

            for (Character character : characters) {
                if (character.getNom().equalsIgnoreCase(nomRecherche)) {
                    personnageChoisi = character;
                }
            }

            if (personnageChoisi != null) {
                System.out.println("Vous avez choisi : " + personnageChoisi);
            } else {
                System.out.println("Aucun personnage trouvé avec le nom : " + nomRecherche);
                System.out.println("On recommence");
                choisirCharacters(scanner);
            }
        }
        return personnageChoisi;
    }

    public void randomAventure(Character personnageChoisi) {

        int random = (int) (Math.random() * 3);
        String event = "";

        File file = new File("events.txt");

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                int boucle = 0;
                while ((line = br.readLine()) != null) {

                    if (boucle == random) {
                        event = line;
                    }
                    boucle++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        switch (event) {
            case "Combat avec un monstre":
                combatMonstre(personnageChoisi);
                break;
            case "Trouve un coffre au tresor":
                trouvreCoffre(personnageChoisi);
                break;
            case "Passe la nuit dans une auberge":
                nuitAuberge(personnageChoisi);
                break;
        }
    }

    private void combatMonstre(Character character) {
        System.out.println("Événement : " + character +" rencontre un monstre dans la forêt.");
        int random = (int) (Math.random() * 2);
        if (random == 0) {
            System.out.println("Résultat :"+ character + " a battu le monstre !");
        } else if (random == 1) {
            System.out.println("Résultat :"+ character + " a fuit le combat ! malheureusement il a prit des dommages, -10 points de santé");
            character.setPv(character.getPv() - 10);
        }

    }

    private void trouvreCoffre(Character character) {
        System.out.println("Événement :"+character +" a trouvé un coffre mystérieux.");
        int random = (int) (Math.random() * 2);
        if (random == 0) {
            System.out.println("Résultat : Le coffre contient une piece d'equpement ! "+character + " gagne 10 points de force.");
            character.setForce(character.getForce() + 10);
        } else if (random == 1) {
            System.out.println("Résultat : Le coffre était piégé ! "+character + " perd 10 points de santé.");
            character.setPv(character.getPv() - 10);
        }
    }

    private void nuitAuberge(Character character) {
        System.out.println("Événement :"+character +" a trouvé une auberge.");

        System.out.println("Résultat : Vous passez la nuit a l'auberge ! "+character + " gagne 50 points de santé.");
        character.setPv(character.getPv() + 50);
    }

    public void partirAventure(Scanner scanner) {

        String journal = "";
        Character character = choisirCharacters(scanner);

        System.out.println(" Combien d'event aura votre Aventure ? :");

        int nbEvent = scanner.nextInt();
        scanner.nextLine();

        System.out.println("            --- Début de l'aventure ---");

        for(int i = 0; i < nbEvent; i++) {
            System.out.println();
            randomAventure(character);
            if(character.getPv() <= 0) {
                System.out.println("\n"+character + " a succomber a ses blessures");
                return;
            }
        }

        System.out.println("\n            --- Fin de l'aventure ---");
        System.out.println(character.getNom() + " santé restante : " + character.getPv());
        System.out.println("Un journal de votre aventure a été généré : journal.txt\n\n\n");

    }
}
