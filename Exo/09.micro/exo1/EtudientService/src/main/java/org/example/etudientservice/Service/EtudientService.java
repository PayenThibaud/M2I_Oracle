package org.example.etudientservice.Service;

import jakarta.persistence.EntityNotFoundException;
import org.example.etudientservice.Dto.EtudientDtoReceive;
import org.example.etudientservice.Dto.EtudientDtoSend;
import org.example.etudientservice.Entity.Etudient;
import org.example.etudientservice.Repository.EtudientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudientService {

    @Autowired
    private EtudientRepository etudientRepository;

    public EtudientService(EtudientRepository etudientRepository) {
        this.etudientRepository = etudientRepository;
    }

    private EtudientDtoSend etudientMapperEtudientDtoSend(Etudient etudient) {
        return EtudientDtoSend.builder()
                .id_etudient(etudient.getId_etudient())
                .nom(etudient.getNom())
                .dateNaissance(etudient.getDateNaissance())
                .build();
    }

    private List<EtudientDtoSend> listeEtudientMapperListeEtudientDtoSend(List<Etudient> etudients) {
        return etudients.stream().map(this::etudientMapperEtudientDtoSend).toList();
    }

    private Etudient findByIdEtudient(int idEtudient) {
        return etudientRepository.findById(idEtudient).orElseThrow(() -> new EntityNotFoundException("Etudiant introuvable avec l'ID : " + idEtudient));
    }

    public EtudientDtoSend getByIdEtudient(int idEtudient) {
        return etudientMapperEtudientDtoSend(findByIdEtudient(idEtudient));
    }

    public List<EtudientDtoSend> getAllEtudient() {
        return listeEtudientMapperListeEtudientDtoSend((List<Etudient>) etudientRepository.findAll());
    }


    public EtudientDtoSend saveEtudient(EtudientDtoReceive etudientDtoReceive) {

        Etudient etudient = Etudient.builder()
                .nom(etudientDtoReceive.getNom())
                .dateNaissance(etudientDtoReceive.getDateNaissance())
                .build();

        return etudientMapperEtudientDtoSend(etudientRepository.save(etudient));
    }

    public EtudientDtoSend updateEtudient(int id, EtudientDtoReceive etudientDtoReceive) {
        Etudient etudient = findByIdEtudient(id);

        etudient.setNom(etudientDtoReceive.getNom());
        etudient.setDateNaissance(etudientDtoReceive.getDateNaissance());

        return etudientMapperEtudientDtoSend(etudientRepository.save(etudient));
    }

    public void deleteEtudient(int id) {
        etudientRepository.delete(findByIdEtudient(id));
    }


}
