package org.example.noteservice.Dto.Note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NoteDtoReceive {
    private int note;
    private int id_matiere;
    private int id_etudient;
}
