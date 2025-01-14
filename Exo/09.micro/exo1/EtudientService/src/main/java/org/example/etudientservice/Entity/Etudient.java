package org.example.etudientservice.Entity;

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
public class Etudient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_etudient;

    private String nom;
    private String dateNaissance;
}
