package org.example.matiereservice.Dto.Prof;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfDtoSend {
    private int id_prof;
    private String nom;
    private String dateNaissance;
}
