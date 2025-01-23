package org.example.demo_test_opti;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/single")
    public Mono<ResponseEntity<String>> getSingle() {
        return Mono.just(ResponseEntity.ok("Hello World"));
    }

    @GetMapping("/stream")
    public Flux<Integer> getStream() {
        return Flux.just(1, 2, 3);
    }

}
