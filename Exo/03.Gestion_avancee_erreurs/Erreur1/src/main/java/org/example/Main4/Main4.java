package org.example.Main4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Student> etudiants = new ArrayList<>();

        boolean boucle = true;

        while (boucle) {
            try {
                System.out.print("nom etudient : ");
                String name = scanner.nextLine();

                System.out.print("age etudient : ");
                int age = Integer.parseInt(scanner.nextLine());

                if (age < 0) {
                    throw new InvalidAgeException("age negative non !");
                }

                etudiants.add(new Student(name, age));
                System.out.println(name + " est ajouter");
            } catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("pas un bon age");
            }

            System.out.print("Voulez-vous ajouter un autre étudiant ? (y) : ");
            String reponse = scanner.nextLine();
            boucle = reponse.equalsIgnoreCase("y");
        }

        System.out.println("Liste des étudiants :");
        for (Student etudiant : etudiants) {
            System.out.println(etudiant.getNom() + " " + etudiant.getAge());
        }
    }
}
