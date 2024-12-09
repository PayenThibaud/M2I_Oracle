package org.example;

@FunctionalInterface
public interface Calculator {

    double  calculate(double a, double b);

    default double Addition(double a, double b){
        return a + b;
    };

    default double Soustraction(double a, double b){
        return a - b;
    };

    default double Multiplication(double a, double b){
        return a * b;
    }

    default double Division(double a, double b){
        if (b == 0) {
            return 0;
        }
        return a / b;
    }
}
