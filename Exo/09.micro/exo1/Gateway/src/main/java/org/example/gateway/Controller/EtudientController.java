package org.example.gateway.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gateway.DTO.Etudient.EtudientDTORequest;
import org.example.gateway.DTO.Etudient.EtudientDTOResponse;
import org.example.gateway.tools.RestClient;
import org.example.gateway.utils.PortAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("etudient")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EtudientController {

    private ObjectMapper objectMapper;

    public EtudientController() {
        this.objectMapper = new ObjectMapper();
    }

    @GetMapping
    public ResponseEntity<List<EtudientDTOResponse>> getAllEtudient() {
        RestClient<EtudientDTOResponse[]> EtudientsRestClient = new RestClient<>("http://localhost:" + PortAPI.portEtudient + "/etudient");
        List<EtudientDTOResponse> responses = Arrays.stream(EtudientsRestClient.getRequest(EtudientDTOResponse[].class)).toList();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudientDTOResponse> getEtudientById (@PathVariable int id){
        RestClient<EtudientDTOResponse> etudientRestClient = new RestClient<>("http://localhost:"+ PortAPI.portEtudient +"/etudient/"+id);
        EtudientDTOResponse etudientDtoResponse = etudientRestClient.getRequest(EtudientDTOResponse.class);
        return new ResponseEntity<>(etudientDtoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EtudientDTOResponse> postEtudient (@RequestBody EtudientDTORequest etudientDtoRequest) throws JsonProcessingException {
        RestClient<EtudientDTOResponse> etudientRestClient = new RestClient<>("http://localhost:"+ PortAPI.portEtudient +"/etudient");
        EtudientDTOResponse etudientDtoResponse = etudientRestClient.postRequest(objectMapper.writeValueAsString(etudientDtoRequest), EtudientDTOResponse.class);
        return new ResponseEntity<>(etudientDtoResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtudientDTOResponse> updateEtudient(@PathVariable int id, @RequestBody EtudientDTORequest etudientDtoRequest) throws JsonProcessingException {
        RestClient<EtudientDTOResponse> etudientRestClient = new RestClient<>("http://localhost:" + PortAPI.portEtudient + "/etudient/" + id);
        EtudientDTOResponse etudientDtoResponse = etudientRestClient.putRequest(objectMapper.writeValueAsString(etudientDtoRequest), EtudientDTOResponse.class);
        return new ResponseEntity<>(etudientDtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEtudient(@PathVariable int id) {
        RestClient<Void> etudientRestClient = new RestClient<>("http://localhost:" + PortAPI.portEtudient + "/etudient/" + id);
        String responseMessage = "L'etudient avec l'ID " + id + " a été supprimé.";
        etudientRestClient.deleteRequest();

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
