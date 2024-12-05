package org.example.creational.factoryMethod;

public class TruckFactory extends VehiculeFacotry{
    @Override
    public Vehicle createVehicule() {
        return new Truck();
    }
}
