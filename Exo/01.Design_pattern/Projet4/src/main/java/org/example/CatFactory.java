package org.example;

public class CatFactory extends AnimalFactory {

    @Override
    IAnimal createAnimal() {
        return new Cat();
    }
}
