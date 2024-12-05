package org.example.alerteLego;

public class ObserverLego implements Observer {

    public String name;

    public ObserverLego(String name) {
        this.name = name;
    }


    @Override
    public void update(String message) {
        System.out.println("Attention les jouets en Lego sont creer en plastique peu importe l usine, msg depuis : " + name);
    }
}
