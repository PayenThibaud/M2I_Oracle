package org.example.etudientservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class EtudientDtoSend {
    private int id_etudient;
    private String nom;
    private String dateNaissance;
}
