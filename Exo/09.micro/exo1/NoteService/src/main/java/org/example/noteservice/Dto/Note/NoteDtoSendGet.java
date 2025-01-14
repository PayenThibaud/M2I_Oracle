package org.example.noteservice.Dto.Note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NoteDtoSendGet {
    private int id_note;
    private int note;
    private int id_matiere;
    private String nomMatiere;
    private int id_etudient;
    private String nomEtudient;
}
