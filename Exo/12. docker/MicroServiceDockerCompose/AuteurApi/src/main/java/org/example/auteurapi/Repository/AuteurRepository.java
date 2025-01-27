package org.example.auteurapi.Repository;

import org.example.auteurapi.Entity.Auteur;
import org.springframework.data.repository.CrudRepository;

public interface AuteurRepository extends CrudRepository<Auteur, Integer> {
}
