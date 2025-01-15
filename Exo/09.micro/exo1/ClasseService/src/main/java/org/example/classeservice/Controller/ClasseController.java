package org.example.classeservice.Controller;

import org.example.classeservice.Dto.ClasseDtoReceive;
import org.example.classeservice.Dto.ClasseDtoSend;
import org.example.classeservice.Service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classe")
public class ClasseController {

    @Autowired
    private ClasseService classeService;


    @GetMapping
    public ResponseEntity<List<ClasseDtoSend>> getAll() {
        return ResponseEntity.ok(classeService.getAllClasse());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasseDtoSend> getById(@PathVariable int id) {
        return ResponseEntity.ok(classeService.getByIdClasse(id));
    }

    @PostMapping
    public ResponseEntity<ClasseDtoSend> create(@RequestBody ClasseDtoReceive classeDtoReceive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(classeService.saveClasse(classeDtoReceive));
    }

    @GetMapping("/etudient/{idEtudient}")
    public ResponseEntity<List<ClasseDtoSend>> getByIdEtudient(@PathVariable int idEtudient) {
        return ResponseEntity.ok(classeService.getAllClasseByEtudient(idEtudient));
    }

    @GetMapping("/prof/{idProf}")
    public ResponseEntity<List<ClasseDtoSend>> getByIdProf(@PathVariable int idProf) {
        return ResponseEntity.ok(classeService.getAllClasseByProf(idProf));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        classeService.deleteClasse(id);
        return ResponseEntity.ok("Classe supprimer avec l'id : " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClasseDtoSend> update(@PathVariable int id, @RequestBody ClasseDtoReceive classeDtoReceive) {
        return ResponseEntity.ok(classeService.updateClasse(id, classeDtoReceive));
    }
}
