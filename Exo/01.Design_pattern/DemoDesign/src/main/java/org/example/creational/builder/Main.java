package org.example.creational.builder;

public class Main {
    public static void main(String[] args) {
        Person person = Person.builder()
                .setFirstName("John")
                .setLastName("Doe")
                .setAge(30)
                .build();

        Person person1 = Person.builder()
                .setFirstName("John")
                .setAge(30)
                .build();

        System.out.println(person.toString());
        System.out.println(person1.toString());
    }
}
