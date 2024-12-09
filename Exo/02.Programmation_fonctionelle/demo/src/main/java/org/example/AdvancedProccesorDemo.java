package org.example;

public class AdvancedProccesorDemo {
    public static void main(String[] args) {

        AdvancedProccessor proccessor = input -> input.trim().toUpperCase();

        System.out.println(proccessor.proccess("hello world"));

        proccessor.print("Hello World");

        AdvancedProccessor.info();
    }
}

