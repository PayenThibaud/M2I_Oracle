package org.example.bookapi.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookDtoSendGet {
    private int id_book;
    private String titre;
    private int id_auteur;
    private String auteur_nom;
}
