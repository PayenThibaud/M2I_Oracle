package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean boucle = true;

        while (boucle) {
            System.out.println("nombre : ");
            String input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);
                System.out.println("Le nombre est : " + number);
                boucle = false;

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Il faut un nombre recommence");
            }
        }
    }
}