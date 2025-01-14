package org.example.gateway.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gateway.DTO.Classe.ClasseDTORequest;
import org.example.gateway.DTO.Classe.ClasseDTOResponse;
import org.example.gateway.tools.RestClient;
import org.example.gateway.utils.PortAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("classe")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClasseController {
    
    private ObjectMapper objectMapper = new ObjectMapper();
    
    public ClasseController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<List<ClasseDTOResponse>> getAllClasse() {
        RestClient<ClasseDTOResponse[]> ClassesRestClient = new RestClient<>("http://localhost:" + PortAPI.portClasse + "/classe");
        List<ClasseDTOResponse> responses = Arrays.stream(ClassesRestClient.getRequest(ClasseDTOResponse[].class)).toList();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasseDTOResponse> getClasseById (@PathVariable int id){
        RestClient<ClasseDTOResponse> classeRestClient = new RestClient<>("http://localhost:"+ PortAPI.portClasse +"/classe/"+id);
        ClasseDTOResponse classeDtoResponse = classeRestClient.getRequest(ClasseDTOResponse.class);
        return new ResponseEntity<>(classeDtoResponse, HttpStatus.OK);
    }

    @GetMapping("/prof/{profId}")
    public ResponseEntity<List<ClasseDTOResponse>> getClasseByIdProf(@PathVariable int profId) {
        RestClient<ClasseDTOResponse[]> classeRestClient = new RestClient<>("http://localhost:" + PortAPI.portClasse + "/classe/prof/" + profId);
        List<ClasseDTOResponse> classeDtoResponses = Arrays.stream(classeRestClient.getRequest(ClasseDTOResponse[].class)).toList();
        return new ResponseEntity<>(classeDtoResponses, HttpStatus.OK);
    }

    @GetMapping("/etudient/{etudientId}")
    public ResponseEntity<List<ClasseDTOResponse>> getClasseByIdEtudient(@PathVariable int etudientId) {
        RestClient<ClasseDTOResponse[]> classeRestClient = new RestClient<>("http://localhost:" + PortAPI.portClasse + "/classe/etudient/" + etudientId);
        List<ClasseDTOResponse> classeDtoResponses = Arrays.stream(classeRestClient.getRequest(ClasseDTOResponse[].class)).toList();
        return new ResponseEntity<>(classeDtoResponses, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<ClasseDTOResponse> postClasse (@RequestBody ClasseDTORequest classeDtoRequest) throws JsonProcessingException {
        RestClient<ClasseDTOResponse> classeRestClient = new RestClient<>("http://localhost:"+ PortAPI.portClasse +"/classe");
        ClasseDTOResponse classeDtoResponse = classeRestClient.postRequest(objectMapper.writeValueAsString(classeDtoRequest), ClasseDTOResponse.class);
        return new ResponseEntity<>(classeDtoResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClasseDTOResponse> updateClasse(@PathVariable int id, @RequestBody ClasseDTORequest classeDtoRequest) throws JsonProcessingException {
        RestClient<ClasseDTOResponse> classeRestClient = new RestClient<>("http://localhost:" + PortAPI.portClasse + "/classe/" + id);
        ClasseDTOResponse classeDtoResponse = classeRestClient.putRequest(objectMapper.writeValueAsString(classeDtoRequest), ClasseDTOResponse.class);
        return new ResponseEntity<>(classeDtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClasse(@PathVariable int id) {
        RestClient<Void> classeRestClient = new RestClient<>("http://localhost:" + PortAPI.portClasse + "/classe/" + id);
        String responseMessage = "L'classe avec l'ID " + id + " a été supprimé.";
        classeRestClient.deleteRequest();

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
