package org.example;

public abstract sealed class Animal permits Bird, Mammal{

    protected int id;
    protected String name;
    protected String species;

    public Animal(int id, String name, String species) {
        this.id = id;
        this.name = name;
        this.species = species;
    }

    public abstract String getDetails();

    public abstract void eat();
}
