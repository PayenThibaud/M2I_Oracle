package org.example;

import java.util.ArrayList;
import java.util.List;

public class Employe implements Employee {
    private String nom;
    private List<Employee> subordonnes = new ArrayList<Employee>();


    public Employe (String nom) {
        this.nom = nom;
    }

    public void addSubordonne(Employee e) {
        subordonnes.add(e);
    }


    @Override
    public void showDetails() {
        System.out.println("L employe : " + nom);
        for (Employee e : subordonnes) {
            e.showDetails();
        }

    }
}
