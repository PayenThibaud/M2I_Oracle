package org.example.demo_test_opti;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ReactiveService {

    public Mono<String> getSingleData(){
        return Mono.just("Hello, Webflux").delayElement(Duration.ofSeconds(2));
    }

    public Flux<Integer> getData(){
        return Flux.just(1, 2, 3,4,5);
    }

    public Flux<Integer> getErrorStream(){
        return Flux.concat(
                Flux.just(1,2,3),
                Flux.error(new RuntimeException("Test exeption")));
    }
}
