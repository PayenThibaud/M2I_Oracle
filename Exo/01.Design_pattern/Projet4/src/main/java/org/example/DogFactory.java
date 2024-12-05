package org.example;

public class DogFactory extends AnimalFactory {

    @Override
    IAnimal createAnimal() {
        return new Dog();
    }
}
