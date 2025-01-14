package org.example.noteservice.Dto.Etudient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtudientDtoSend {
    private int id_etudient;
    private String nom;
    private String dateNaissance;
}
