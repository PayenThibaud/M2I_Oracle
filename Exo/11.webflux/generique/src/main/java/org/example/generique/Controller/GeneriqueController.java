package org.example.generique.Controller;

import org.example.generique.Service.IGeneriqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class GeneriqueController<T, ID> implements IGeneriqueController<T, ID> {

   protected final IGeneriqueService<T, ID> generiqueService;

    public GeneriqueController(IGeneriqueService<T, ID> generiqueService) {
        this.generiqueService = generiqueService;
    }


    @Override
    @GetMapping
    public Flux<T> findAll() {
        return generiqueService.findAll();
    }

    @Override
    @GetMapping("{id}")
    public Mono<ResponseEntity<T>> findById(@PathVariable ID id) {
        return generiqueService.findById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Override
    @PostMapping
    public Mono<ResponseEntity<T>> save(@RequestBody T entity) {
        return generiqueService.save(entity).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Override
    @PutMapping("{id}")
    public Mono<ResponseEntity<T>> update(@RequestBody T entity, @PathVariable ID id) {
        return generiqueService.update(id, entity).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Override
    @DeleteMapping("{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable ID id) {
        return generiqueService.deleteById(id).then(Mono.just(ResponseEntity.noContent().build()));
    }
}
