package org.example.aspect2.service;

import org.example.aspect2.annotation.LoginAspect;
import org.example.aspect2.entity.ObjetCeleste;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ObjetCelesteService implements IObjetCelesteService {
    Map<Integer, ObjetCeleste> objetCelestes = new HashMap<>();
    Integer id = 1;

    @Override
    @LoginAspect
    public List<ObjetCeleste> getAllObjetCeleste() {
        return objetCelestes.values().stream().collect(Collectors.toList());
    }

    @Override
    @LoginAspect
    public ObjetCeleste getObjetCelesteById(int id) {
        return objetCelestes.get(id);
    }

    @Override
    @LoginAspect
    public List<ObjetCeleste> getAllObjetCelesteByNom(String nom) {
        return objetCelestes.values().stream()
                .filter(objetCeleste -> objetCeleste.getNom().equalsIgnoreCase(nom))
                .collect(Collectors.toList());
    }

    @Override
    @LoginAspect
    public ObjetCeleste addObjetCeleste(String nom, String gps, String description, LocalDate date) {
        ObjetCeleste objetCeleste = new ObjetCeleste(nom, gps, description, date);
        objetCelestes.put(id++, objetCeleste);
        return objetCeleste;
    }
}


