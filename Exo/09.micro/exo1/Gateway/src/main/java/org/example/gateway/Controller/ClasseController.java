package org.example.gateway.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gateway.DTO.Classe.ClasseDTORequest;
import org.example.gateway.DTO.Classe.ClasseDTOResponse;
import org.example.gateway.DTO.Classe.ClasseDTOResponseGet;
import org.example.gateway.DTO.Etudient.EtudientDTOResponse;
import org.example.gateway.DTO.Prof.ProfDTOResponse;
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

    private void rechercherNomEtudient(List<ClasseDTOResponseGet> classeDtoResponsGets) {
        for (ClasseDTOResponseGet classe : classeDtoResponsGets) {
            RestClient<EtudientDTOResponse> etudientRestClient = new RestClient<>("http://localhost:" + PortAPI.portEtudient + "/etudient/" + classe.getId_etudient());
            EtudientDTOResponse etudientDtoResponse = etudientRestClient.getRequest(EtudientDTOResponse.class);
            classe.setNomEtudient(etudientDtoResponse.getNom());
        }
    }

    private void rechercherNomProf(List<ClasseDTOResponseGet> classeDtoResponsGets) {
        for (ClasseDTOResponseGet classe : classeDtoResponsGets) {
            RestClient<ProfDTOResponse> profRestClient = new RestClient<>("http://localhost:" + PortAPI.portProf + "/prof/" + classe.getId_prof());
            ProfDTOResponse profDtoResponse = profRestClient.getRequest(ProfDTOResponse.class);
            classe.setNomProf(profDtoResponse.getNom());
        }
    }

    @GetMapping
    public ResponseEntity<List<ClasseDTOResponseGet>> getAllClasse() {
        RestClient<ClasseDTOResponseGet[]> ClassesRestClient = new RestClient<>("http://localhost:" + PortAPI.portClasse + "/classe");
        List<ClasseDTOResponseGet> responses = Arrays.stream(ClassesRestClient.getRequest(ClasseDTOResponseGet[].class)).toList();

        rechercherNomProf(responses);
        rechercherNomEtudient(responses);

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasseDTOResponseGet> getClasseById (@PathVariable int id){
        RestClient<ClasseDTOResponseGet> classeRestClient = new RestClient<>("http://localhost:"+ PortAPI.portClasse +"/classe/"+id);
        ClasseDTOResponseGet classeDtoResponseGet = classeRestClient.getRequest(ClasseDTOResponseGet.class);

        rechercherNomEtudient(Arrays.asList(classeDtoResponseGet));
        rechercherNomProf(Arrays.asList(classeDtoResponseGet));

        return new ResponseEntity<>(classeDtoResponseGet, HttpStatus.OK);
    }

    @GetMapping("/prof/{profId}")
    public ResponseEntity<List<ClasseDTOResponseGet>> getClasseByIdProf(@PathVariable int profId) {
        RestClient<ClasseDTOResponseGet[]> classeRestClient = new RestClient<>("http://localhost:" + PortAPI.portClasse + "/classe/prof/" + profId);
        List<ClasseDTOResponseGet> classeDtoResponsGets = Arrays.stream(classeRestClient.getRequest(ClasseDTOResponseGet[].class)).toList();

        rechercherNomProf(classeDtoResponsGets);
        rechercherNomEtudient(classeDtoResponsGets);

        return new ResponseEntity<>(classeDtoResponsGets, HttpStatus.OK);
    }

    @GetMapping("/etudient/{etudientId}")
    public ResponseEntity<List<ClasseDTOResponseGet>> getClasseByIdEtudient(@PathVariable int etudientId) {
        RestClient<ClasseDTOResponseGet[]> classeRestClient = new RestClient<>("http://localhost:" + PortAPI.portClasse + "/classe/etudient/" + etudientId);
        List<ClasseDTOResponseGet> classeDtoResponsGets = Arrays.stream(classeRestClient.getRequest(ClasseDTOResponseGet[].class)).toList();

        rechercherNomProf(classeDtoResponsGets);
        rechercherNomEtudient(classeDtoResponsGets);

        return new ResponseEntity<>(classeDtoResponsGets, HttpStatus.OK);
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
