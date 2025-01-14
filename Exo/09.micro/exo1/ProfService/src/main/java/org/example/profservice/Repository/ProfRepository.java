package org.example.profservice.Repository;

import org.example.profservice.Entity.Prof;
import org.springframework.data.repository.CrudRepository;

public interface ProfRepository extends CrudRepository<Prof, Integer> {
}
