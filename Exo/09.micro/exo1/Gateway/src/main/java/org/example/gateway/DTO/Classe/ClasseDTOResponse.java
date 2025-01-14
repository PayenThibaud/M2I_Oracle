package org.example.gateway.DTO.Classe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClasseDTOResponse {
    private int id_classe;

    private String nom;

    private int id_etudient;
    private int id_prof;
}
