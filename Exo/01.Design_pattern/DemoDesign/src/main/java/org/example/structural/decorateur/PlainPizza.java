package org.example.structural.decorateur;

public class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Piiiiiiiiiiiizzzzzzzaaaaa";
    }

    @Override
    public double getPrice() {
        return 5.00;
    }
}
