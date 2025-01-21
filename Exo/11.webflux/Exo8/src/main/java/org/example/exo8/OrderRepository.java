package org.example.exo8;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OrderRepository extends ReactiveCrudRepository<Order, Integer> {
    Flux<Order> findByStatus(Status status);

    Flux<Order> findAllBy(Pageable pageable);
}
