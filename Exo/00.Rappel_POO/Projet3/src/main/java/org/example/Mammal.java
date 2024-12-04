package org.example;

public final class Mammal extends Animal{

    private boolean isHerbivore;

    public Mammal(int id, String name, String species, boolean isHerbivore) {
        super(id, name, species);
        this.isHerbivore = isHerbivore;
    }

    @Override
    public String getDetails() {
        return "Mammal " + id + " { name : " + name + ", species : " + species + ", isHerbivore : " + isHerbivore + " }";
    }

    @Override
    public void eat() {
        if(isHerbivore){
            System.out.println(name + " broute de l herbe");
        } else {
            System.out.println(name + " mange son voisin 😶");
        }
    }
}
