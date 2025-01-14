package org.example.matiereservice.Entity;

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
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_matiere;
    private String nom;
    private int coeficient;

    @Column(name = "id_prof")
    private int idProf;

}
