package org.example.structural.decorateur;

public class OliveDecorator extends PizzaDecorator{

    public OliveDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " avec Olive";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 0.05;
    }
}
