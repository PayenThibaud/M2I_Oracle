package org.example;

public class StringProcessDemo {
    public static void main(String[] args) {
        StringProcess toUpperCaseProcessor = string -> string.toUpperCase();
        System.out.println(toUpperCaseProcessor.process("Hello World"));
    }
}
