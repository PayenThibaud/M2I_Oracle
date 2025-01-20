package org.example.exo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class BasicController {

    @GetMapping("/welcome")
    public Mono<String> getWelcome() {
        return Mono.just("Welcome to Project Reactor!");
    }

    @GetMapping("/number")
    public Flux<Integer> getNumber() {
        return Flux.range(1, 5);
    }
}
