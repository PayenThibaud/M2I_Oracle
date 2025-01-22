package org.example.exo10;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @GetMapping
    public String rooms() {
        return "Aucune salle de disponible, mais vous etes connecté";
    }

    @PostMapping
    public String addRoom() {
        return "Il n y a plus de place pour ajouter une salle, mais vous etes connecté en tant qu admin";
    }

    @DeleteMapping
    public String deleteRoom() {
        return "Il n y a aucune salle a supprimer, mais vous etes connecté en tant qu admin";
    }
}
