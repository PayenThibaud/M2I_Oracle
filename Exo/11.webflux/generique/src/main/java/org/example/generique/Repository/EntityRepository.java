package org.example.generique.Repository;

import org.example.generique.Entity.EntityGenerique;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EntityRepository extends ReactiveCrudRepository<EntityGenerique, Integer> {
}
