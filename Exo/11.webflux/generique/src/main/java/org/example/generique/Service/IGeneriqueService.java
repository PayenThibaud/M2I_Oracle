package org.example.generique.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IGeneriqueService<T, ID> {

    Flux<T> findAll();

    Mono<T> findById(ID id);

    Mono<T> save(T t);

    Mono<T> update(ID id, T newEntity);

    Mono<Void> deleteById(ID id);
}
