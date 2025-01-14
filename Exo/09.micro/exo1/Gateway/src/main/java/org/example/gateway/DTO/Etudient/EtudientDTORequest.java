package org.example.gateway.DTO.Etudient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtudientDTORequest {
    private String nom;
    private String dateNaissance;
}
