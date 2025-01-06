package app;

import mySecondPackage.Voiture;
import mypackage.Personne;
import mypackage.mySubPackage.Animal;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Personne> people;

    private static Voiture voiture;

    private static Animal animal;

    public static void main(String[] args) {

        people = new ArrayList<>(List.of(new Personne("Titi", 20), new Personne("Toto", 25)));

        for (Personne p : people) {
            System.out.println(p);
        }


    }
}