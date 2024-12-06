package org.example;

public interface IHouseBuilder {
    IHouseBuilder setHouseName(String houseName);
    IHouseBuilder setEtage(int etage);
    IHouseBuilder setTypeToit(String typeToit);
    IHouseBuilder setPiscine(boolean piscine);
    House build();
}