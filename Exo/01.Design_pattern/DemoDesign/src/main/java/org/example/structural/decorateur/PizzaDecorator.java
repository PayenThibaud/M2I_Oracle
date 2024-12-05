package org.example.structural.decorateur;

public abstract class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription(){
        return pizza.getDescription();
    };

    @Override
    public double getPrice(){
        return pizza.getPrice();
    };
}
