package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = (double a, double b) -> 0;

        Map<String, Calculator> operations = new HashMap<>();
        operations.put("addition", calculator::Addition);
        operations.put("soustraction", calculator::Soustraction);
        operations.put("multiplication", calculator::Multiplication);
        operations.put("division", calculator::Division);

        Consumer<String> afficheConsole = message -> {
            System.out.println(message);
        };

        boolean boucle = true;

        while (boucle) {
            Scanner scanner = new Scanner(System.in);

            afficheConsole.accept("- Calculator 2000 -");
            afficheConsole.accept("Chiffre a : ");
            double a = scanner.nextDouble();

            afficheConsole.accept("Chiffre b : ");
            double b = scanner.nextDouble();

            afficheConsole.accept("Choisissez une opération : ");
            afficheConsole.accept("1 : Addition ");
            afficheConsole.accept("2 : Soustraction");
            afficheConsole.accept("3 : Multiplication");
            afficheConsole.accept("4 : Division :");
            afficheConsole.accept("5 : Sortir :");

            String operation = scanner.next();

            Calculator op = null;

            switch (operation) {
                case "1":
                     op = operations.get("addition");
                    break;
                case "2":
                     op = operations.get("soustraction");
                    break;
                case "3":
                     op = operations.get("multiplication");
                    break;
                case "4":
                     op = operations.get("division");
                    break;
                case "5":
                    afficheConsole.accept("BYE BYE");
                    boucle = false;
                    break;
                default:
                    afficheConsole.accept("Erreur, recommence");
                    break;
            }
            double result = op.calculate(a, b);
            afficheConsole.accept("Résultat : " + result);
        }
    }
}