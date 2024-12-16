package org.example.aspect2.controller;

import org.example.aspect2.entity.ObjetCeleste;
import org.example.aspect2.service.IObjetCelesteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objet-celeste")
public class ObjetCelesteController {

    private final IObjetCelesteService objetCelesteService;

    @Autowired
    public ObjetCelesteController(IObjetCelesteService objetCelesteService) {
        this.objetCelesteService = objetCelesteService;
    }

    @GetMapping
    public List<ObjetCeleste> getAllObjetCeleste() {
        return objetCelesteService.getAllObjetCeleste();
    }

    @GetMapping("/{id}")
    public ObjetCeleste getObjetCelesteById(@PathVariable int id) {
        return objetCelesteService.getObjetCelesteById(id);
    }

    @GetMapping("/nom/{nom}")
    public List<ObjetCeleste> getObjetCelesteByNom(@PathVariable String nom) {
        return objetCelesteService.getAllObjetCelesteByNom(nom);
    }

    @PostMapping
    public ObjetCeleste addObjetCeleste(@RequestBody ObjetCeleste objetCeleste) {
        return objetCelesteService.addObjetCeleste(
                objetCeleste.getNom(),
                objetCeleste.getGps(),
                objetCeleste.getDescription(),
                objetCeleste.getDate()
        );
    }
}
