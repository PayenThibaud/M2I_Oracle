package org.example;

import java.util.List;

public class Enclosure {

    private int id;
    private String name;
    private List<Animal> animals;

    public Enclosure(int id, String name, List<Animal> animals) {
        this.id = id;
        this.name = name;
        this.animals = animals;
    }

    public String getName() {
        return this.name;
    }

    public String addAnimal(Animal animal) {
        animals.add(animal);
        return "L animal : " + animal.name + " est ajoute dans l enclos : " + name ;
    }

    public String removeAnimal(Animal animal) {
        animals.remove(animal);
        return "L animal : " + animal.name + " est retire de l enclos : " + name ;
    }

    public String getAllAnimal() {
        String listAnimal = "";
        for (Animal animal : animals) {
            listAnimal += animal.name + ", ";
        }
        return listAnimal ;
    }


}
