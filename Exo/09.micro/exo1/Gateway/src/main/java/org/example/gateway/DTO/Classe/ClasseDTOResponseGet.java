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
public class ClasseDTOResponseGet {
    @JsonProperty("id_classe")
    private int id_classe;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("id_etudient")
    private int id_etudient;
    @JsonProperty("nomEtudient")
    private String nomEtudient;
    @JsonProperty("id_prof")
    private int id_prof;
    @JsonProperty("nomProf")
    private String nomProf;
}
