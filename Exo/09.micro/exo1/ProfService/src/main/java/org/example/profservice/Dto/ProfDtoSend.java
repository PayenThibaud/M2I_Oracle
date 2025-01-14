package org.example.profservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProfDtoSend {
    private int id_prof;

    private String nom;
    private String dateNaissance;
}
