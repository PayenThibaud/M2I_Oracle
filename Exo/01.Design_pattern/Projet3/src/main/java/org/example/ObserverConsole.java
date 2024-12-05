package org.example;

public class ObserverConsole implements IObserver {

    public String name;

    public ObserverConsole(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(message + " : " + name);
    }
}