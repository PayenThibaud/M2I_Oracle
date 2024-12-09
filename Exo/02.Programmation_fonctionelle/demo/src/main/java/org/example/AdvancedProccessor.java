package org.example;

@FunctionalInterface
public interface AdvancedProccessor {
    String proccess(String input);

    default void print(String input){
        System.out.println("traitement de : " + input);
    }

    static void info(){
        System.out.println("Interface fonctionelle personnalisee pour le traitement de string");
    }
}
