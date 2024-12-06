package org.example;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee{
    private String nom;
    private List<Employee> subordonnes = new ArrayList<Employee>();


    public Manager (String nom) {
        this.nom = nom;
    }

    public void addSubordonne(Employee e) {
        subordonnes.add(e);
    }


    @Override
    public void showDetails() {
        System.out.println("Le Manager : " + nom);
        for (Employee e : subordonnes) {
            e.showDetails();
        }

    }
}

