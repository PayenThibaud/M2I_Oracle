package org.example.exo14.Entity;

public class Order {

    private int id;
    private String item;

    public Order(int id, String item) {
        this.id = id;
        this.item = item;
    }

    public Order() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}

