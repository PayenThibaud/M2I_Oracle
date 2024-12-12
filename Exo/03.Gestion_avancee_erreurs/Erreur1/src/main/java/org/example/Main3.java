package org.example;

public class Main3 {
    public static void main(String[] args) {
        int[] tableau = {1, 2, 3, 4, 5};

        try {
            System.out.println("Accès au sixième élément du tableau : " + tableau[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("L index est au dela de la taille du tableau");
        }
    }
}
