package org.example.exo2bash.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class JouetDtoSend {
    private int id_jouet;

    private String nom;
    private String description;
    private int prix;
}
