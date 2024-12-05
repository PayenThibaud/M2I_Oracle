package org.example.Factory;

import org.example.jouet.Bateau.Bateau;
import org.example.jouet.Bateau.BateauPlastique;
import org.example.jouet.Drone.Drone;
import org.example.jouet.Drone.DronePlastique;
import org.example.jouet.Lego.Lego;
import org.example.jouet.Lego.LegoPlastique;
import org.example.jouet.Velo.Velo;
import org.example.jouet.Velo.VeloPlastique;
import org.example.jouet.Voiture.Voiture;
import org.example.jouet.Voiture.VoiturePlastique;


public class PlastiqueFactory implements IJouetFactory {

    @Override
    public Drone createDrone() {
        return new DronePlastique();
    }

    @Override
    public Voiture createVoiture() {
        return new VoiturePlastique();
    }

    @Override
    public Bateau createBateau() {
        return new BateauPlastique();
    }

    @Override
    public Velo createVelo() {
        return new VeloPlastique();
    }

    @Override
    public Lego createLego() {
        return new LegoPlastique();
    }
}
