package org.example.noteservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_note;

    private int note;

    @Column(name = "id_matiere")
    private int idMatiere;
    @Column(name = "id_etudient")
    private int idEtudient;
    @Column(name = "id_prof")
    private int idProf;
}
