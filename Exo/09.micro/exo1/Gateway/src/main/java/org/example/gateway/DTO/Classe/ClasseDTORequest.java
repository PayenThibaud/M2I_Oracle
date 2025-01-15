package org.example.gateway.DTO.Classe;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClasseDTORequest {

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("id_etudient")
    private int id_etudient;
    @JsonProperty("id_prof")
    private int id_prof;
}
