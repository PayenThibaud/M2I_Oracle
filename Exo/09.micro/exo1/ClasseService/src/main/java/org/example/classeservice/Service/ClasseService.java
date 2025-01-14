package org.example.classeservice.Service;

import jakarta.persistence.EntityNotFoundException;
import org.example.classeservice.Dto.ClasseDtoReceive;
import org.example.classeservice.Dto.ClasseDtoSend;
import org.example.classeservice.Entity.Classe;
import org.example.classeservice.Repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {
    
    @Autowired
    private ClasseRepository classeRepository;

    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    private ClasseDtoSend classeMapperClasseDtoSend(Classe classe) {
        return ClasseDtoSend.builder()
                .id_classe(classe.getId_classe())
                .nom(classe.getNom())
                .id_etudient(classe.getIdEtudient())
                .id_prof(classe.getIdProf())
                .build();
    }

    private List<ClasseDtoSend> listeClasseMapperListeClasseDtoSend(List<Classe> classes) {
        return classes.stream().map(this::classeMapperClasseDtoSend).toList();
    }

    private Classe findByIdClasse(int idClasse) {
        return classeRepository.findById(idClasse).orElseThrow(() -> new EntityNotFoundException("Etudiant introuvable avec l'ID : " + idClasse));
    }

    public ClasseDtoSend getByIdClasse(int idClasse) {
        return classeMapperClasseDtoSend(findByIdClasse(idClasse));
    }

    public List<ClasseDtoSend> getAllClasse() {
        return listeClasseMapperListeClasseDtoSend((List<Classe>) classeRepository.findAll());
    }

    public List<ClasseDtoSend> getAllClasseByProf(int idProf) {
        return listeClasseMapperListeClasseDtoSend((List<Classe>) classeRepository.getClassesByIdProf(idProf));
    }

    public List<ClasseDtoSend> getAllClasseByEtudient(int idEtudient) {
        return listeClasseMapperListeClasseDtoSend((List<Classe>) classeRepository.getClassesByIdEtudient(idEtudient));
    }


    public ClasseDtoSend saveClasse(ClasseDtoReceive classeDtoReceive) {

        Classe classe = Classe.builder()
                .nom(classeDtoReceive.getNom())
                .idEtudient(classeDtoReceive.getId_etudient())
                .idProf(classeDtoReceive.getId_prof())
                .build();

        return classeMapperClasseDtoSend(classeRepository.save(classe));
    }

    public ClasseDtoSend updateClasse(int id, ClasseDtoReceive classeDtoReceive) {
        Classe classe = findByIdClasse(id);

        classe.setNom(classeDtoReceive.getNom());
        classe.setIdEtudient(classeDtoReceive.getId_etudient());
        classe.setIdProf(classeDtoReceive.getId_prof());

        return classeMapperClasseDtoSend(classeRepository.save(classe));
    }

    public void deleteClasse(int id) {
        classeRepository.delete(findByIdClasse(id));
    }


}

