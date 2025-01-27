package org.example.auteurapi.Service;

import org.example.auteurapi.Dto.AuteurDtoReceive;
import org.example.auteurapi.Dto.AuteurDtoSend;
import org.example.auteurapi.Entity.Auteur;
import org.example.auteurapi.Repository.AuteurRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AuteurService extends GeneriqueServiceImpl<AuteurDtoReceive, AuteurDtoSend, Auteur> {

  private final AuteurRepository auteurRepository;

    public AuteurService(AuteurRepository auteurRepository) {
        super(auteurRepository);
        this.auteurRepository = auteurRepository;
    }


    @Override
    protected AuteurDtoSend mapToResponse(Auteur auteur) {
        return AuteurDtoSend.builder()
                .id_auteur(auteur.getId_auteur())
                .nom(auteur.getNom())
                .build();
    }

    @Override
    protected Auteur mapToEntity(AuteurDtoReceive dto) {
        return Auteur.builder()
                .nom(dto.getNom())
                .build();
    }

    @Override
    public String getEntityName() {
        return "auteur";
    }
}
