package jouetMain;

import packageSpecial.Jouet;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Jouet> jouets;


    public static void main(String[] args) {

        jouets = new ArrayList<>(List.of(new Jouet(1, "Yo-yo"), new Jouet(2, "Camion")));

        for (Jouet j : jouets) {
            System.out.println(j);
        }


    }
}