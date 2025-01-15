package org.example.classeservice.Service.Generique;

import org.example.classeservice.Dto.ClasseDtoReceive;
import org.example.classeservice.Dto.ClasseDtoSend;
import org.example.classeservice.Entity.Classe;
import org.example.classeservice.Repository.ClasseRepository;
import org.example.classeservice.Service.Generique.GeneriqueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseServiceUseGenerique extends GeneriqueServiceImpl<ClasseDtoReceive, ClasseDtoSend, Classe> {

    @Autowired
    private final ClasseRepository classeRepository;

    public ClasseServiceUseGenerique(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    protected ClasseDtoSend mapToResponse(Classe classe) {
        return ClasseDtoSend.builder()
                .id_classe(classe.getId_classe())
                .nom(classe.getNom())
                .id_etudient(classe.getIdEtudient())
                .id_prof(classe.getIdProf())
                .build();
    }

    @Override
    protected Classe mapToEntity(ClasseDtoReceive classeDtoReceive) {
        return Classe.builder()
                .nom(classeDtoReceive.getNom())
                .idEtudient(classeDtoReceive.getId_etudient())
                .idProf(classeDtoReceive.getId_prof())
                .build();
    }

    @Override
    public List<ClasseDtoSend> getAllEntities() {
        return super.getAllEntities();
    }

    @Override
    public ClasseDtoSend getEntityById(int id) {
        return super.getEntityById(id);
    }

    @Override
    public ClasseDtoSend createEntity(ClasseDtoReceive classeDtoReceive) {
        return super.createEntity(classeDtoReceive);
    }

    @Override
    public ClasseDtoSend updateEntity(int id, ClasseDtoReceive classeDtoReceive) {
        return super.updateEntity(id, classeDtoReceive);
    }

    @Override
    public void deleteEntity(int id) {
        super.deleteEntity(id);
    }
}
