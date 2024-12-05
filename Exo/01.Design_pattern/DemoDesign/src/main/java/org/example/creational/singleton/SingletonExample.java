package org.example.creational.singleton;

public class SingletonExample {

    private static SingletonExample instance;
    private String name;

    private SingletonExample(String name) {
        this.name = name;
    }

    public static synchronized SingletonExample getInstance(String name) {
        if (instance == null) {
            instance = new SingletonExample(name);
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
