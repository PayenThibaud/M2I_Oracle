package org.example;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean boucle = true;

            while (boucle) {
                System.out.println("nombre positif :");
                String input = scanner.nextLine();

                try {
                    long nombre = Long.parseLong(input);

                    if (nombre < 0) {
                        throw new IllegalArgumentException("pas de negatif");
                    }

                    double racineCarree = Math.sqrt(nombre);
                    System.out.println("La racine carrée de " + nombre + " est : " + racineCarree);
                    boucle = false;
                } catch (NumberFormatException e) {
                    System.out.println("rentre un chiffre");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }