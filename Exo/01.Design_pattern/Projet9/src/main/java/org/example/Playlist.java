package org.example;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Music> musics = new ArrayList<>();

    public void addMusic(Music music) {
        musics.add(music);
        System.out.println(music.getNom() + " ajouter");
    }

    public void removeMusic(Music music) {
        if (musics.remove(music)) {
            System.out.println(music.getNom() + " supprimer");
        } else {
            System.out.println(music.getNom() + " n est pas dans la playlist");
        }
    }

    public void getAllMusic() {
        System.out.println("Toute les music de la playlist :");
        if (musics.isEmpty()) {
            System.out.println("vide");
        } else {
            for (Music music : musics) {
                System.out.println("  - " + music.getNom());
            }
        }
    }
}
