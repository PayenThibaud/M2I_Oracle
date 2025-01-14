package org.example.gateway.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gateway.DTO.Note.NoteDTOResponseGet;
import org.example.gateway.DTO.Note.NoteDTORequest;
import org.example.gateway.DTO.Note.NoteDTOResponse;
import org.example.gateway.tools.RestClient;
import org.example.gateway.utils.PortAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("note")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class NoteController {

    private ObjectMapper objectMapper;

    public NoteController() {
        this.objectMapper = new ObjectMapper();
    }

    @GetMapping
    public ResponseEntity<List<NoteDTOResponseGet>> getAllNotes() {
        RestClient<NoteDTOResponseGet[]> notesRestClient = new RestClient<>("http://localhost:" + PortAPI.portNote + "/note");
        List<NoteDTOResponseGet> responses = Arrays.stream(notesRestClient.getRequest(NoteDTOResponseGet[].class)).toList();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDTOResponseGet> getNoteById(@PathVariable int id) {
        RestClient<NoteDTOResponseGet> noteRestClient = new RestClient<>("http://localhost:" + PortAPI.portNote + "/note/" + id);
        NoteDTOResponseGet noteDtoResponse = noteRestClient.getRequest(NoteDTOResponseGet.class);
        return new ResponseEntity<>(noteDtoResponse, HttpStatus.OK);
    }

    @GetMapping("/etudiant/{idEtudient}")
    public ResponseEntity<List<NoteDTOResponseGet>> getByIdEtudiant(@PathVariable int idEtudient) {
        RestClient<NoteDTOResponseGet[]> notesRestClient = new RestClient<>("http://localhost:" + PortAPI.portNote + "/note/etudient/" + idEtudient);
        List<NoteDTOResponseGet> responses = Arrays.stream(notesRestClient.getRequest(NoteDTOResponseGet[].class)).toList();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/matiere/{idMatiere}")
    public ResponseEntity<List<NoteDTOResponseGet>> getByIdMatiere(@PathVariable int idMatiere) {
        RestClient<NoteDTOResponseGet[]> notesRestClient = new RestClient<>("http://localhost:" + PortAPI.portNote + "/note/matiere/" + idMatiere);
        List<NoteDTOResponseGet> responses = Arrays.stream(notesRestClient.getRequest(NoteDTOResponseGet[].class)).toList();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NoteDTOResponse> postNote(@RequestBody NoteDTORequest noteDtoRequest) throws JsonProcessingException {
        RestClient<NoteDTOResponse> noteRestClient = new RestClient<>("http://localhost:" + PortAPI.portNote + "/note");
        NoteDTOResponse noteDtoResponse = noteRestClient.postRequest(objectMapper.writeValueAsString(noteDtoRequest), NoteDTOResponse.class);
        return new ResponseEntity<>(noteDtoResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteDTOResponse> updateNote(@PathVariable int id, @RequestBody NoteDTORequest noteDtoRequest) throws JsonProcessingException {
        RestClient<NoteDTOResponse> noteRestClient = new RestClient<>("http://localhost:" + PortAPI.portNote + "/note/" + id);
        NoteDTOResponse noteDtoResponse = noteRestClient.putRequest(objectMapper.writeValueAsString(noteDtoRequest), NoteDTOResponse.class);
        return new ResponseEntity<>(noteDtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable int id) {
        RestClient<Void> noteRestClient = new RestClient<>("http://localhost:" + PortAPI.portNote + "/note/" + id);
        String responseMessage = "La note avec l'ID " + id + " a été supprimée.";
        noteRestClient.deleteRequest();

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
