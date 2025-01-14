package org.example.matiereservice.Repository;

import org.example.matiereservice.Entity.Matiere;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MatiereRepository extends CrudRepository<Matiere, Integer> {

    List<Matiere> findByIdProf(int idProf);
}
