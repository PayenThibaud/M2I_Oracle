package org.example;

import java.util.Scanner;

public class Ihm {
    public void start() {

        boolean ihm = true;
        JournalHandler jh = new JournalHandler();
        Scanner sc = new Scanner(System.in);

        while (ihm) {
            System.out.println("--- Menu ---");
            System.out.println("1. Ajouter une activité");
            System.out.println("2. Afficher les activités");
            System.out.println("3. Sauvegarder en binaire");
            System.out.println("4. Lire le fichier binaire");
            System.out.println("5. Ajouter une activiter choix limiter");
            System.out.println("6. Quitter");

            System.out.println("Choisissez une option : ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    jh.ajouterActiviter();
                    break;

                case "2":
                    jh.afficherJournal();
                    break;

                case "3":
                    jh.sauvegarderBinaireJournal();
                    break;

                case "4":
                    jh.lireJournalBinaire();
                    break;

                case "5":
                    jh.ajouterActiviterChoixLimiter();
                    break;

                case "6":
                    System.out.println("bye");
                    ihm = false;
                    break;
            }
        }
    }
}
