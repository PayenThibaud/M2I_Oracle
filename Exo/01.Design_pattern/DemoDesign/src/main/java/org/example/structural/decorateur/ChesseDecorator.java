package org.example.structural.decorateur;

public class ChesseDecorator extends PizzaDecorator {

    public ChesseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " au fromage";
    };

    @Override
    public double getPrice(){
        return super.getPrice() + 0.5;
    };
}
