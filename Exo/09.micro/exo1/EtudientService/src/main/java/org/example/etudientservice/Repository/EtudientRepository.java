package org.example.etudientservice.Repository;

import org.example.etudientservice.Entity.Etudient;
import org.springframework.data.repository.CrudRepository;

public interface EtudientRepository extends CrudRepository<Etudient, Integer> {
}
