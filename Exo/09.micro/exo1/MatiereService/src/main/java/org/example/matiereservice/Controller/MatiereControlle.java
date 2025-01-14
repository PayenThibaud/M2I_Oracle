package org.example.matiereservice.Controller;

import org.example.matiereservice.Dto.Matiere.MatiereDtoReceive;
import org.example.matiereservice.Dto.Matiere.MatiereDtoSend;
import org.example.matiereservice.Dto.Matiere.MatiereDtoSendGet;
import org.example.matiereservice.Dto.Prof.ProfDtoSend;
import org.example.matiereservice.Service.MatiereService;
import org.example.matiereservice.tools.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/matiere")
public class MatiereControlle {


    @Autowired
    private MatiereService matiereService;


    @GetMapping
    public ResponseEntity<List<MatiereDtoSendGet>> getAll() {
        return ResponseEntity.ok(matiereService.getAllMatieres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatiereDtoSendGet> getById(@PathVariable int id) {
        return ResponseEntity.ok(matiereService.getByIdMatiere(id));
    }

    @GetMapping("/prof/{idProf}")
    public ResponseEntity<List<MatiereDtoSendGet>> getByIdProf(@PathVariable int idProf) {
        return ResponseEntity.ok(matiereService.getMatieresByProf(idProf));
    }

    @PostMapping
    public ResponseEntity<MatiereDtoSend> create(@RequestBody MatiereDtoReceive matiereDtoReceive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(matiereService.saveMatiere(matiereDtoReceive));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        matiereService.deleteMatiere(id);
        return ResponseEntity.ok("matiere supprimer avec l'id : " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatiereDtoSend> update(@PathVariable int id, @RequestBody MatiereDtoReceive matiereDtoReceive) {
        return ResponseEntity.ok(matiereService.updateMatiere(id, matiereDtoReceive));
    }
}
