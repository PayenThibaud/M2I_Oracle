package org.example.Factory;

import org.example.jouet.Bateau.Bateau;
import org.example.jouet.Drone.Drone;
import org.example.jouet.Lego.Lego;
import org.example.jouet.Velo.Velo;
import org.example.jouet.Voiture.Voiture;

public interface IJouetFactory {
    Drone createDrone();
    Voiture createVoiture();
    Bateau createBateau();
    Velo createVelo();
    Lego createLego();
}
