package org.example.classeservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_classe;

    private String nom;

    @Column(name = "id_etudient")
    private int idEtudient;

    @Column(name = "id_prof")
    private int idProf;


}
