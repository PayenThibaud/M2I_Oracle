package org.example.creational.builder;

public class Main {
    public static void main(String[] args) {
        Person person = Person.builder()
                .setFirstName("Titi")
                .setLastName("Tata")
                .setAge(20)
                .build();

        Person person1 = Person.builder()
                .setFirstName("Toto")
                .setAge(990)
                .build();

        System.out.println(person.toString());
        System.out.println(person1.toString());
    }
}
