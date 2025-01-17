package org.example.exo2bash.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Jouet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_jouet;

    private String nom;
    private String description;
    private int prix;
}
