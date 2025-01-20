package org.example.exo4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @GetMapping("/articles")
    public Flux<String> articles() {
        return Flux.just("Introduction to Spring WebFlux", "Reactive Programming with Project Reactor", "Building APIs with Spring Boot");
    }
}
