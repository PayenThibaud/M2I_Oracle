package org.example;

public class Main {
    public static void main(String[] args) {
        AnimalFactory catFactory = new CatFactory();
        AnimalFactory dogFactory = new DogFactory();

        IAnimal cat = catFactory.createAnimal();
        IAnimal dog = dogFactory.createAnimal();

        cat.noise();
        dog.noise();
    }
}