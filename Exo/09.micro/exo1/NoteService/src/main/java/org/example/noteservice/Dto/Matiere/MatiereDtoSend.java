package org.example.noteservice.Dto.Matiere;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatiereDtoSend {
    private int id_matiere;
    private String nom;
    private int coeficient;
    private int id_Prof;
}
