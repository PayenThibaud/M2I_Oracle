package org.example;

public class Main {
    public static void main(String[] args) {


        House house = House.builderModerneHouse().setHouseName("maison moderne").setEtage(10).build();

        House house2 = House.builderTradiHouse().setHouseName("maison tradi").setPiscine(true).build();

        System.out.println(house);
        System.out.println(house2);
    }
}