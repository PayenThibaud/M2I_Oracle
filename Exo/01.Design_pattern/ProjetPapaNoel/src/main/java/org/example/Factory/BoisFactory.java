package org.example.Factory;

import org.example.jouet.Bateau.Bateau;
import org.example.jouet.Bateau.BateauBois;
import org.example.jouet.Drone.Drone;
import org.example.jouet.Drone.DroneBois;
import org.example.jouet.Lego.Lego;
import org.example.jouet.Lego.LegoPlastique;
import org.example.jouet.Velo.Velo;
import org.example.jouet.Velo.VeloBois;
import org.example.jouet.Voiture.Voiture;
import org.example.jouet.Voiture.VoitureBois;
import org.example.alerteLego.Observer;

import java.util.ArrayList;
import java.util.List;

public class BoisFactory implements IJouetFactory {

    private List<Observer> observerLegos = new ArrayList<Observer>();

    public void addObserverLego(Observer observerLego) {
        observerLegos.add(observerLego);
    }

    public void notifyObserverLegos(String message) {
        for (Observer observerLego : observerLegos) {
            observerLego.update(message);
        }
    }



    @Override
    public Drone createDrone() {
        return new DroneBois();
    }

    @Override
    public Voiture createVoiture() {
        return new VoitureBois();
    }

    @Override
    public Bateau createBateau() {
        return new BateauBois();
    }

    @Override
    public Velo createVelo() {
        return new VeloBois();
    }

    @Override
    public Lego createLego() {
        notifyObserverLegos("");
        return new LegoPlastique();
    }


}
