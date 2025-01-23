package org.example.exo13.MusiqueService;

import org.example.exo13.Entity.Musique;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusiqueService {

    private List<Musique> musiques = List.of(
            new Musique(1, "Titre1", "Genre1"),
            new Musique(2, "Titre2", "Genre2"),
            new Musique(1, "Titre3", "Genre1"),
            new Musique(1, "Titre4", "Genre1"),
            new Musique(1, "Titre5", "Genre1")
    );

    public Flux<String> getMusiques(String genre) {

        boolean genreExiste = musiques.stream()
                .anyMatch(musique -> musique.getGenre().equalsIgnoreCase(genre));

        if (!genreExiste) {
            return Flux.error(new  IllegalArgumentException("Musique avec le genre : " + genre + " n'existe pas"));
        }

        return Flux.fromIterable(
                musiques.stream()
                        .filter(musique -> musique.getGenre().equalsIgnoreCase(genre))
                        .map(Musique::getNom)
                        .collect(Collectors.toList()));
    }


}
