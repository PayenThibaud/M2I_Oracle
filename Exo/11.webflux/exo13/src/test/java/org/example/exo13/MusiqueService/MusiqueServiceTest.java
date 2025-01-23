package org.example.exo13.MusiqueService;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class MusiqueServiceTest {

    private final MusiqueService service = new MusiqueService();

    @Test
    void testGetMusiqueGenre2() {
        StepVerifier.create(service.getMusiques("Genre2"))
                .expectSubscription()
                .expectNext("Titre2")
                .verifyComplete();
    }

    @Test
    void testGetMusiqueGenre1() {
        StepVerifier.create(service.getMusiques("Genre1"))
                .expectSubscription()
                .expectNext("Titre1","Titre3","Titre4","Titre5")
                .verifyComplete();
    }

    @Test
    void testGetMusiqueError() {
        StepVerifier.create(service.getMusiques("Error"))
                .expectSubscription()
                .expectErrorMatches(throwable -> throwable instanceof IllegalArgumentException
                && throwable.getMessage().equals("Musique avec le genre : Error n'existe pas"))
                .verify();
    }
}
