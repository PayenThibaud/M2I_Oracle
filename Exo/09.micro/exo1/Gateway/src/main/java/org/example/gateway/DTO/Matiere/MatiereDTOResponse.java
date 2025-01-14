package org.example.gateway.DTO.Matiere;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MatiereDTOResponse {
    private int id_matiere;
    private String nom;
    private int coeficient;
    private int id_Prof;
}
