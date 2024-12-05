package org.example.structural.decorateur;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new PlainPizza();
        System.out.println(pizza.getDescription());

        System.out.println(pizza.getPrice());

        Pizza chessePizza = new ChesseDecorator(pizza);

        System.out.println(chessePizza.getDescription());
        System.out.println(chessePizza.getPrice());

        Pizza pizza2 = new OliveDecorator(chessePizza);
        System.out.println(pizza2.getDescription());
        System.out.println(pizza2.getPrice());
    }
}
