package org.example.classeservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClasseDtoSend {
    private int id_classe;

    private String nom;

    private int id_etudient;
    private int id_prof;
}
