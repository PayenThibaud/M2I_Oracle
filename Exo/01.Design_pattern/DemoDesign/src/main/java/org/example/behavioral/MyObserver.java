package org.example.behavioral;

public class MyObserver implements Observer {

    public String name;

    public MyObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(this.name + ": " + message);
    }
}
