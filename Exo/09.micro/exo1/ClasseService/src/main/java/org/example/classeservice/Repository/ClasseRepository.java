package org.example.classeservice.Repository;

import org.example.classeservice.Entity.Classe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClasseRepository extends CrudRepository<Classe, Integer> {

    List<Classe> getClassesByIdEtudient(int idEtudient);

    List<Classe> getClassesByIdProf(int idProf);
}
