package org.example.creational;

public class Main {
    public static void main(String[] args) {
        SingletonExample singletonExample1 = SingletonExample.getInstance("Titi");
        SingletonExample singletonExample2 = SingletonExample.getInstance("Tata");

        System.out.println(singletonExample1.getName());
        System.out.println(singletonExample2.getName());


        singletonExample2.setName("Tata");
        System.out.println(singletonExample1.getName());
        System.out.println(singletonExample2.getName());


        System.out.println(singletonExample1 == singletonExample2);
    }
}
