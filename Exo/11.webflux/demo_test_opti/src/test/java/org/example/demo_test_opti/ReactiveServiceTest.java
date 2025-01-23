package org.example.demo_test_opti;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class ReactiveServiceTest {


    private final ReactiveService reactiveService = new ReactiveService();

    @Test
    void testGetSingleData(){
        StepVerifier.create(reactiveService.getSingleData())
                .expectSubscription()
                .expectNext("Hello, Webflux")
                .verifyComplete();
    }


    @Test
    void testGetDataStream(){
        StepVerifier.create(reactiveService.getData())
                .expectSubscription()
                .expectNext(1,2,3,4,5)
                .verifyComplete();
    }

    @Test
    void testErrorStream(){
        StepVerifier.create(reactiveService.getErrorStream())
                .expectSubscription()
                .expectNext(1,2,3)
                .expectErrorMatches(throwable -> throwable instanceof RuntimeException
                && throwable.getMessage().equals("Test exeption"))
                .verify();

    }

}
