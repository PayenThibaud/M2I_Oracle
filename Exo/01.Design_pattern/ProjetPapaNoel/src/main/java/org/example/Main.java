package org.example;

import org.example.Factory.BoisFactory;
import org.example.alerteLego.Observer;
import org.example.alerteLego.ObserverLego;
import org.example.qualiter.IJouet;
import org.example.qualiter.LuxeDecorator;
import org.example.qualiter.PremiumDecorator;

public class Main {
    public static void main(String[] args){

        BoisFactory boisFactory = new BoisFactory();

        Observer observer = new ObserverLego("ObserverLego");
        boisFactory.addObserverLego(observer);

        IJouet bateau = boisFactory.createBateau();
        System.out.println(bateau.afficherMatiere());

        IJouet veloPremium = new PremiumDecorator(boisFactory.createVelo());
        System.out.println(veloPremium.afficherMatiere());


        IJouet legoLuxe = new LuxeDecorator(boisFactory.createLego());
        System.out.println(legoLuxe.afficherMatiere());

    }
}