package org.example.creational.factoryMethod;

public class Main {
    public static void main(String[] args) {
        VehiculeFacotry carFactory = new CarFactory();
        VehiculeFacotry truckFactory = new TruckFactory();

        Vehicle car = carFactory.createVehicule();
        car.drive();

        Vehicle truck = truckFactory.createVehicule();
        truck.drive();
    }
}
