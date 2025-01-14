package org.example.noteservice.Controller;

import org.example.noteservice.Dto.Note.NoteDtoReceive;
import org.example.noteservice.Dto.Note.NoteDtoSend;
import org.example.noteservice.Dto.Note.NoteDtoSendGet;
import org.example.noteservice.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    
    @Autowired
    private NoteService noteService;


    @GetMapping
    public ResponseEntity<List<NoteDtoSendGet>> getAll() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDtoSendGet> getById(@PathVariable int id) {
        return ResponseEntity.ok(noteService.getByIdNote(id));
    }

    @GetMapping("/etudient/{idEtudient}")
    public ResponseEntity<List<NoteDtoSendGet>> getByIdEtudient(@PathVariable int idEtudient) {
        return ResponseEntity.ok(noteService.getNotesByIdEtudient(idEtudient));
    }

    @GetMapping("/matiere/{idMatiere}")
    public ResponseEntity<List<NoteDtoSendGet>> getByIdMatiere(@PathVariable int idMatiere) {
        return ResponseEntity.ok(noteService.getNotesByIdMatiere(idMatiere));
    }

    @PostMapping
    public ResponseEntity<NoteDtoSend> create(@RequestBody NoteDtoReceive noteDtoReceive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(noteService.saveNote(noteDtoReceive));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok("note supprimer avec l'id : " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteDtoSend> update(@PathVariable int id, @RequestBody NoteDtoReceive noteDtoReceive) {
        return ResponseEntity.ok(noteService.updateNote(id, noteDtoReceive));
    }
}
