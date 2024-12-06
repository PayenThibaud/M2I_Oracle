package org.example;

public class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "Titi";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void sayHello() {
        System.out.println("Hello " + name + " et j ai " + age);
    }

}