package org.example.etudientservice.Controller;

import org.example.etudientservice.Dto.EtudientDtoReceive;
import org.example.etudientservice.Dto.EtudientDtoSend;
import org.example.etudientservice.Service.EtudientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudient")
public class EtudientController {

    @Autowired
    private EtudientService etudientService;

    @GetMapping
    public ResponseEntity<List<EtudientDtoSend>> getAll() {
        return ResponseEntity.ok(etudientService.getAllEtudient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudientDtoSend> getById(@PathVariable int id) {
        return ResponseEntity.ok(etudientService.getByIdEtudient(id));
    }

    @PostMapping
    public ResponseEntity<EtudientDtoSend> create(@RequestBody EtudientDtoReceive etudientDtoReceive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(etudientService.saveEtudient(etudientDtoReceive));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        etudientService.deleteEtudient(id);
        return ResponseEntity.ok("Etudient supprimer avec l'id : " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtudientDtoSend> update(@PathVariable int id, @RequestBody EtudientDtoReceive etudientDtoReceive) {
        return ResponseEntity.ok(etudientService.updateEtudient(id, etudientDtoReceive));
    }

}
