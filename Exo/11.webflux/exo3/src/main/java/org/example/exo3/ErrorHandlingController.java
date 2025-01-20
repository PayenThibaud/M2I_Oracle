package org.example.exo3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ErrorHandlingController {

    @GetMapping("/error-resume")
    public Flux<String> errorResume() {
        return Flux.just("a", "b", "c", "d", "e", "f", "g", "h")
        .map(f -> {
            if ("c".equals(f)) {
                throw new RuntimeException("Error, c");
            }
            return f;
        })
                .onErrorResume(e -> Flux.just( "default1" , "default2"));
    }

    @GetMapping("/error-continu")
    public Flux<Integer> errorContinu() {
        return Flux.range(1, 5)
                .map(f ->{
                    if (f == 2) {
                        throw new RuntimeException("Error, 2");
                    }
                    return f;
                })
                .onErrorContinue((e, f) -> {
                    System.err.println("Error sur la methode errorContinu : " + f + " : "
                    + e.getMessage());
                });
    }
}

