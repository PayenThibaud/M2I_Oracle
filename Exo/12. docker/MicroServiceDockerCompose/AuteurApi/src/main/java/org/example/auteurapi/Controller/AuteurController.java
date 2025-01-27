package org.example.auteurapi.Controller;

import org.example.auteurapi.Dto.AuteurDtoReceive;
import org.example.auteurapi.Dto.AuteurDtoSend;
import org.example.auteurapi.Service.AuteurService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 ###
 POST http://localhost:8082/auteur
 Content-Type: application/json

 {
 "nom": "Toto"
 }
 */

@RestController
@RequestMapping("/auteur")
public class AuteurController extends GeneriqueController<AuteurDtoReceive, AuteurDtoSend, AuteurService> {
    public AuteurController(AuteurService service) {
        super(service);
    }
}
