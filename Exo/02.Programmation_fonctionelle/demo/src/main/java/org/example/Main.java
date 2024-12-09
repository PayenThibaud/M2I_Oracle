package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("apple", "orange", "banana");
        fruits.sort((f1, f2) -> f1.compareTo(f2));
        System.out.println(fruits);

        Function<String, Integer> stringLength = s -> s.length();

        System.out.println(stringLength.apply("apple"));

        String input = "Bonjour";
        int length = stringLength.apply(input);
        System.out.println(length);

        Consumer<String> printMessage = System.out::println;
        printMessage.accept("Hello");

        Consumer<String> printMessage2 = message ->{
            System.out.println(message);
        };
        printMessage2.accept("World");

        Predicate<Integer> isEven = number -> number % 2 == 0;


        int testNumber = 4;
        if (isEven.test(testNumber)) {
            System.out.println("Even");
        }else
            System.out.println("Odd");

        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);
        System.out.println(randomSupplier.get());

        int testNumber2 = randomSupplier.get();
        if(isEven.test(testNumber2)) {
            System.out.println("Even");
        }else
            System.out.println("Odd");


    }
}