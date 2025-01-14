package org.example.noteservice.Repository;

import org.example.noteservice.Entity.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Integer> {

    List<Note> findByIdEtudient(int idEtudient);

    List<Note> findByIdMatiere(int idMatiere);
}
