package org.example.gateway.DTO.Prof;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfDTOResponse {
    private int id_prof;
    private String nom;
    private String dateNaissance;
}
