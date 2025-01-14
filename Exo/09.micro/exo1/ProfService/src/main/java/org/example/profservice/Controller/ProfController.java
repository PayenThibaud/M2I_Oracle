package org.example.profservice.Controller;

import org.example.profservice.Dto.ProfDtoReceive;
import org.example.profservice.Dto.ProfDtoSend;
import org.example.profservice.Service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prof")
public class ProfController {

    @Autowired
    private ProfService profService;


    @GetMapping
    public ResponseEntity<List<ProfDtoSend>> getAll() {
        return ResponseEntity.ok(profService.getAllProf());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfDtoSend> getById(@PathVariable int id) {
        return ResponseEntity.ok(profService.getByIdProf(id));
    }

    @PostMapping
    public ResponseEntity<ProfDtoSend> create(@RequestBody ProfDtoReceive profDtoReceive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(profService.saveprof(profDtoReceive));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        profService.deleteProf(id);
        return ResponseEntity.ok("Prof supprimer avec l'id : " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfDtoSend> update(@PathVariable int id, @RequestBody ProfDtoReceive profDtoReceive) {
        return ResponseEntity.ok(profService.updateProf(id, profDtoReceive));
    }

}

