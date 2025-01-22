package org.example.exo11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/projects")
public class ProjetController {

    @GetMapping
    public String getProjects() {
        return "Vous avez reussi a vous connecter a nos Projets";
    }
}
