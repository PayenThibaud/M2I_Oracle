package org.example.gateway.DTO.Etudient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtudientDTOResponse {
    private int id_etudient;
    private String nom;
    private String dateNaissance;
}
