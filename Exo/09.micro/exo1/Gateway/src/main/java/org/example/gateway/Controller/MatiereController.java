package org.example.gateway.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gateway.DTO.Matiere.MatiereDTORequest;
import org.example.gateway.DTO.Matiere.MatiereDTOResponse;
import org.example.gateway.DTO.Matiere.MatiereDTOResponseGet;
import org.example.gateway.tools.RestClient;
import org.example.gateway.utils.PortAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("matiere")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MatiereController {

    private ObjectMapper objectMapper;

    public MatiereController() {
        this.objectMapper = new ObjectMapper();
    }

    @GetMapping
    public ResponseEntity<List<MatiereDTOResponseGet>> getAllMatieres() {
        RestClient<MatiereDTOResponseGet[]> matieresRestClient = new RestClient<>("http://localhost:" + PortAPI.portMatiere + "/matiere");
        List<MatiereDTOResponseGet> responses = Arrays.stream(matieresRestClient.getRequest(MatiereDTOResponseGet[].class)).toList();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatiereDTOResponseGet> getMatiereById(@PathVariable int id) {
        RestClient<MatiereDTOResponseGet> matiereRestClient = new RestClient<>("http://localhost:" + PortAPI.portMatiere + "/matiere/" + id);
        MatiereDTOResponseGet matiereDtoResponse = matiereRestClient.getRequest(MatiereDTOResponseGet.class);
        return new ResponseEntity<>(matiereDtoResponse, HttpStatus.OK);
    }

    @GetMapping("/prof/{idProf}")
    public ResponseEntity<List<MatiereDTOResponseGet>> getByIdProf(@PathVariable int idProf) {
        RestClient<MatiereDTOResponseGet[]> matieresRestClient = new RestClient<>("http://localhost:" + PortAPI.portMatiere + "/matiere/prof/" + idProf);
        List<MatiereDTOResponseGet> responses = Arrays.stream(matieresRestClient.getRequest(MatiereDTOResponseGet[].class)).toList();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MatiereDTOResponse> postMatiere(@RequestBody MatiereDTORequest matiereDtoRequest) throws JsonProcessingException {
        RestClient<MatiereDTOResponse> matiereRestClient = new RestClient<>("http://localhost:" + PortAPI.portMatiere + "/matiere");
        MatiereDTOResponse matiereDtoResponse = matiereRestClient.postRequest(objectMapper.writeValueAsString(matiereDtoRequest), MatiereDTOResponse.class);
        return new ResponseEntity<>(matiereDtoResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatiereDTOResponse> updateMatiere(@PathVariable int id, @RequestBody MatiereDTORequest matiereDtoRequest) throws JsonProcessingException {
        RestClient<MatiereDTOResponse> matiereRestClient = new RestClient<>("http://localhost:" + PortAPI.portMatiere + "/matiere/" + id);
        MatiereDTOResponse matiereDtoResponse = matiereRestClient.putRequest(objectMapper.writeValueAsString(matiereDtoRequest), MatiereDTOResponse.class);
        return new ResponseEntity<>(matiereDtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMatiere(@PathVariable int id) {
        RestClient<Void> matiereRestClient = new RestClient<>("http://localhost:" + PortAPI.portMatiere + "/matiere/" + id);
        String responseMessage = "La matière avec l'ID " + id + " a été supprimée.";
        matiereRestClient.deleteRequest();

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}

