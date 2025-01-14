package org.example.gateway.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gateway.DTO.Prof.ProfDTORequest;
import org.example.gateway.DTO.Prof.ProfDTOResponse;
import org.example.gateway.tools.RestClient;
import org.example.gateway.utils.PortAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("prof")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProfController {

    private ObjectMapper objectMapper;

    public ProfController() {
        this.objectMapper = new ObjectMapper();
    }

    @GetMapping
    public ResponseEntity<List<ProfDTOResponse>> getAllProf() {
        RestClient<ProfDTOResponse[]> ProfsRestClient = new RestClient<>("http://localhost:" + PortAPI.portProf + "/prof");
        List<ProfDTOResponse> responses = Arrays.stream(ProfsRestClient.getRequest(ProfDTOResponse[].class)).toList();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfDTOResponse> getProfById (@PathVariable int id){
        RestClient<ProfDTOResponse> profRestClient = new RestClient<>("http://localhost:"+ PortAPI.portProf +"/prof/"+id);
        ProfDTOResponse profDtoResponse = profRestClient.getRequest(ProfDTOResponse.class);
        return new ResponseEntity<>(profDtoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProfDTOResponse> postProf (@RequestBody ProfDTORequest profDtoRequest) throws JsonProcessingException {
        RestClient<ProfDTOResponse> profRestClient = new RestClient<>("http://localhost:"+ PortAPI.portProf +"/prof");
        ProfDTOResponse profDtoResponse = profRestClient.postRequest(objectMapper.writeValueAsString(profDtoRequest), ProfDTOResponse.class);
        return new ResponseEntity<>(profDtoResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfDTOResponse> updateProf(@PathVariable int id, @RequestBody ProfDTORequest profDtoRequest) throws JsonProcessingException {
        RestClient<ProfDTOResponse> profRestClient = new RestClient<>("http://localhost:" + PortAPI.portProf + "/prof/" + id);
        ProfDTOResponse profDtoResponse = profRestClient.putRequest(objectMapper.writeValueAsString(profDtoRequest), ProfDTOResponse.class);
        return new ResponseEntity<>(profDtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProf(@PathVariable int id) {
        RestClient<Void> profRestClient = new RestClient<>("http://localhost:" + PortAPI.portProf + "/prof/" + id);
        String responseMessage = "Le prof avec l'ID " + id + " a été supprimé.";
        profRestClient.deleteRequest();

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}

