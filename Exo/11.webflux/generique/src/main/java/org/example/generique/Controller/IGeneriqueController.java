package org.example.generique.Controller;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IGeneriqueController<T, ID> {

    Flux<T> findAll();

    Mono<ResponseEntity<T>> findById(ID id);

    Mono<ResponseEntity<T>> save(T entity);

    Mono<ResponseEntity<T>> update(T entity, ID id);

    Mono<ResponseEntity<Void>> delete(ID id);
}
