package org.example.matiereservice.Dto.Matiere;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MatiereDtoSendGet {
    private int id_matiere;
    private String nom;
    private int coeficient;
    private int id_Prof;
    private String nomProf;
}
