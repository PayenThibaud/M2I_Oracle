package org.example.creational.factoryMethod;

public class CarFactory extends VehiculeFacotry{

    @Override
    public Vehicle createVehicule() {
        return new Car();
    }
}
