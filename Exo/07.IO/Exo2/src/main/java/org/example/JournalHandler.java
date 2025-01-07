package org.example;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


public class JournalHandler {


    public void ajouterActiviter() {
        String journal = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom de l activiter");
        String nomActiviter = sc.nextLine();


        File file = new File("Journal.txt");
        if (file.exists()) {

            try (BufferedReader reader = new BufferedReader(new FileReader("Journal.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    journal += line + "\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Journal.txt"))) {

            writer.write(journal);
            SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date date = new Date();
            writer.write(s.format(date) + " - " + nomActiviter + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

        sauvegardeAutoToutLes5Activiter();
    }


    public void afficherJournal() {

        File file = new File("Journal.txt");
        if (file.exists()) {

            try (BufferedReader reader = new BufferedReader(new FileReader("Journal.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Aucun journal");
        }
    }


    public void sauvegarderBinaireJournal() {
        String journal = "";

        File file = new File("Journal.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader("Journal.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    journal += line + "\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Aucun journal");
        }

        try (FileOutputStream out = new FileOutputStream("Journal_backup.dat")) {

            out.write(journal.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lireJournalBinaire() {

        File file = new File("Journal_backup.dat");
        if (file.exists()) {
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("Journal_backup.dat"))) {

                byte[] buffer = new byte[1024];
                while (in.read(buffer) != -1) {
                    System.out.println(new String(buffer));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Aucune sauvegarde du journal");
        }

    }

    public void sauvegardeAutoToutLes5Activiter() {

        int nbActivites = 0;

        File file = new File("Journal.txt");
        if (file.exists()) {

            try (BufferedReader reader = new BufferedReader(new FileReader("Journal.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    nbActivites++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if (nbActivites % 5 == 0) {
            sauvegarderBinaireJournal();
        }
    }


    public void ajouterActiviterChoixLimiter() {

        HashMap<Integer, String> choixLimiter = new HashMap();
        int nbCompteurs = 1;

        File fileA = new File("Activiter.txt");
        if (fileA.exists()) {

            try (BufferedReader reader = new BufferedReader(new FileReader("Activiter.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(nbCompteurs + " - " + line);
                    choixLimiter.put(nbCompteurs, line);
                    nbCompteurs++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            Scanner sc = new Scanner(System.in);
            System.out.println("Entrer le chiffre de l activiter a rajouter au journal");
            int chiffreActiviter = Integer.parseInt(sc.nextLine());

            String nomActiviter = choixLimiter.get(chiffreActiviter);


            String journal = "";
            File file = new File("Journal.txt");
            if (file.exists()) {

                try (BufferedReader reader = new BufferedReader(new FileReader("Journal.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        journal += line + "\n";
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Journal.txt"))) {

                writer.write(journal);
                SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                Date date = new Date();
                writer.write(s.format(date) + " - " + nomActiviter + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }



            sauvegardeAutoToutLes5Activiter();

        } else {
            System.out.println("Aucun dossier activiter");
        }



    }


}
