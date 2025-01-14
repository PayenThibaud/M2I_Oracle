package org.example.noteservice.Service;

import jakarta.persistence.EntityNotFoundException;
import org.example.noteservice.Dto.Classe.ClasseDtoSend;
import org.example.noteservice.Dto.Etudient.EtudientDtoSend;
import org.example.noteservice.Dto.Matiere.MatiereDtoSend;
import org.example.noteservice.Dto.Note.NoteDtoReceive;
import org.example.noteservice.Dto.Note.NoteDtoSend;
import org.example.noteservice.Dto.Note.NoteDtoSendGet;
import org.example.noteservice.Dto.Prof.ProfDtoSend;
import org.example.noteservice.Entity.Note;
import org.example.noteservice.Repository.NoteRepository;
import org.example.noteservice.tools.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    private void rechercherNomEtudient(List<NoteDtoSendGet> noteDtoSendGets) {
        for (NoteDtoSendGet note : noteDtoSendGets) {
            RestClient<EtudientDtoSend> etudientRestClient = new RestClient<>("http://localhost:" + 8081 + "/etudient/" + note.getId_etudient());

            try {
                EtudientDtoSend etudientDtoResponse = etudientRestClient.getRequest(EtudientDtoSend.class);
                note.setNomEtudient(etudientDtoResponse.getNom());
            } catch (Exception e) {
                System.err.println("Erreur, du service etudient pour la note avec l'ID " + note.getId_etudient());
                e.printStackTrace();
                note.setNomEtudient("Nom indisponible");
            }
        }
    }


    private void rechercherNomMatiere(List<NoteDtoSendGet> noteDtoSendGets) {
        for (NoteDtoSendGet note : noteDtoSendGets) {
            RestClient<MatiereDtoSend> matiereRestClient = new RestClient<>("http://localhost:" + 8084 + "/matiere/" + note.getId_matiere());

            try {
                MatiereDtoSend matiereDtoResponse = matiereRestClient.getRequest(MatiereDtoSend.class);
                note.setNomMatiere(matiereDtoResponse.getNom());
            } catch (Exception e) {
                System.err.println("Erreur, du service matiere pour la note avec l'ID " + note.getId_note());
                e.printStackTrace();
                note.setNomEtudient("Nom indisponible");
            }
        }
    }

    private void rechercherNomProf(List<NoteDtoSendGet> noteDtoSendGets) {
        for (NoteDtoSendGet note : noteDtoSendGets) {
            RestClient<ProfDtoSend> profRestClient = new RestClient<>("http://localhost:" + 8082 + "/prof/" + note.getId_prof());

            try {
                ProfDtoSend profDtoResponse = profRestClient.getRequest(ProfDtoSend.class);
                note.setNomProf(profDtoResponse.getNom());
            } catch (Exception e) {
                System.err.println("Erreur, du service prof pour la note avec l'ID " + note.getId_prof());
                e.printStackTrace();
                note.setNomEtudient("Nom indisponible");
            }
        }
    }

    private NoteDtoSendGet agregationNoteDtoSendGet(Note note) {
        return NoteDtoSendGet.builder()
                .id_note(note.getId_note())
                .id_etudient(note.getIdEtudient())
                .id_matiere(note.getIdMatiere())
                .id_prof(note.getIdProf())
                .note(note.getNote())
                .build();
    }

    private List<NoteDtoSendGet> agregationListNoteDtoSendGet(List<Note> notes) {

        List<NoteDtoSendGet> noteDtoSendGets = notes.stream()
                .map(this::agregationNoteDtoSendGet)
                .toList();

        rechercherNomEtudient(noteDtoSendGets);
        rechercherNomMatiere(noteDtoSendGets);
        rechercherNomProf(noteDtoSendGets);
        
        return noteDtoSendGets;
    }


    private NoteDtoSend noteMapperNoteDtoSend(Note note) {
        return NoteDtoSend.builder()
                .id_note(note.getId_note())
                .id_etudient(note.getIdEtudient())
                .id_matiere(note.getIdMatiere())
                .id_prof(note.getIdProf())
                .note(note.getNote())
                .build();
    }
    
    private Note findNoteById(int id) {
        return noteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Note introuvable avec l'ID : " + id));
    }
    
    public NoteDtoSendGet getByIdNote(int id) {
        Note note = findNoteById(id);
        List<NoteDtoSendGet> listNote = agregationListNoteDtoSendGet(Arrays.asList(note));
        return listNote.isEmpty() ? null : listNote.get(0);
    }

    public List<NoteDtoSendGet> getAllNotes() {
        List<Note> notes = (List<Note>) noteRepository.findAll();
        return agregationListNoteDtoSendGet(notes);
    }

    public List<NoteDtoSendGet> getNotesByIdEtudient(int idEtudient) {
        List<Note> notes = noteRepository.findByIdEtudient(idEtudient);
        return agregationListNoteDtoSendGet(notes);
    }

    public List<NoteDtoSendGet> getNotesByIdMatiere(int idMatiere) {
        List<Note> notes = noteRepository.findByIdMatiere(idMatiere);
        return agregationListNoteDtoSendGet(notes);
    }

    public NoteDtoSend saveNote(NoteDtoReceive noteDtoReceive) {
        Note note = Note.builder()
                .note(noteDtoReceive.getNote())
                .idEtudient(noteDtoReceive.getId_etudient())
                .idMatiere(noteDtoReceive.getId_matiere())
                .idProf(noteDtoReceive.getId_prof())
                .build();

        RestClient<ClasseDtoSend[]> classeRestClient = new RestClient<>("http://localhost:" + 8083 + "/classe/prof/" + note.getIdProf());

        try {
            ClasseDtoSend[] classes = classeRestClient.getRequest(ClasseDtoSend[].class);

            boolean etudiantTrouve = false;
            for (ClasseDtoSend classe : classes) {
                if (classe.getId_etudient() == note.getIdEtudient()) {
                    etudiantTrouve = true;
                }
            }

            if (etudiantTrouve) {
                return noteMapperNoteDtoSend(noteRepository.save(note));
            } else {
                throw new Exception("L'étudiant n est pas dans la classe du prof avec l'id: " + note.getIdProf());
            }
        } catch (Exception e) {
            System.err.println("Erreur, du service classe pour le prof avec l'ID " + note.getIdProf());
            e.printStackTrace();
            return null;
        }
    }

    public NoteDtoSend updateNote(int id, NoteDtoReceive noteDtoReceive) {
        Note note = findNoteById(id);

        note.setNote(noteDtoReceive.getNote());
        note.setIdEtudient(noteDtoReceive.getId_etudient());
        note.setIdMatiere(noteDtoReceive.getId_matiere());
        note.setIdProf(noteDtoReceive.getId_prof());

        return noteMapperNoteDtoSend(noteRepository.save(note));
    }

    public void deleteNote(int id) {
        noteRepository.deleteById(id);
    }
}
