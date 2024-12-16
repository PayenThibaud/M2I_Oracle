package org.example.aspect2.service;

import org.example.aspect2.entity.ObjetCeleste;

import java.time.LocalDate;
import java.util.List;

public interface IObjetCelesteService {

    List<ObjetCeleste> getAllObjetCeleste();
    ObjetCeleste getObjetCelesteById(int id);
    List<ObjetCeleste> getAllObjetCelesteByNom(String nom);
    ObjetCeleste addObjetCeleste(String nom, String gps, String description, LocalDate date);
}

