package org.example.profservice.Service;

import jakarta.persistence.EntityNotFoundException;
import org.example.profservice.Dto.ProfDtoReceive;
import org.example.profservice.Dto.ProfDtoSend;
import org.example.profservice.Entity.Prof;
import org.example.profservice.Repository.ProfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfService {

    @Autowired
    private ProfRepository profRepository;

    public ProfService(ProfRepository profRepository) {
        this.profRepository = profRepository;
    }


    private ProfDtoSend profMapperProfDtoSend(Prof prof) {
        return ProfDtoSend.builder()
                .id_prof(prof.getId_prof())
                .nom(prof.getNom())
                .dateNaissance(prof.getDateNaissance())
                .build();
    }

    private List<ProfDtoSend> listeProfMapperListeProfDtoSend(List<Prof> profs) {
        return profs.stream().map(this::profMapperProfDtoSend).toList();
    }

    private Prof findByIdProf(int idProf) {
        return profRepository.findById(idProf).orElseThrow(() -> new EntityNotFoundException("Prof introuvable avec l'ID : " + idProf));
    }

    public ProfDtoSend getByIdProf(int idProf) {
        return profMapperProfDtoSend(findByIdProf(idProf));
    }

    public List<ProfDtoSend> getAllProf() {
        return listeProfMapperListeProfDtoSend((List<Prof>) profRepository.findAll());
    }


    public ProfDtoSend saveprof(ProfDtoReceive profDtoReceive) {

        Prof prof = Prof.builder()
                .nom(profDtoReceive.getNom())
                .dateNaissance(profDtoReceive.getDateNaissance())
                .build();

        return profMapperProfDtoSend(profRepository.save(prof));
    }

    public ProfDtoSend updateProf(int id, ProfDtoReceive profDtoReceive) {
        Prof prof = findByIdProf(id);

        prof.setNom(profDtoReceive.getNom());
        prof.setDateNaissance(profDtoReceive.getDateNaissance());

        return profMapperProfDtoSend(profRepository.save(prof));
    }

    public void deleteProf(int id) {
        profRepository.delete(findByIdProf(id));
    }


}
