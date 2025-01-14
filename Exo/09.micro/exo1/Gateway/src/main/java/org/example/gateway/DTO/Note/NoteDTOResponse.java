package org.example.gateway.DTO.Note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NoteDTOResponse {
    private int id_note;
    private int note;
    private int id_matiere;
    private int id_etudient;
}
