package org.example.exo2bash.Service;

import org.example.exo2bash.Dto.JouetDtoReceive;
import org.example.exo2bash.Dto.JouetDtoSend;
import org.example.exo2bash.Entity.Jouet;
import org.example.exo2bash.Repository.JouetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class JouetService extends GeneriqueServiceImpl<JouetDtoReceive, JouetDtoSend, Jouet> {

    @Autowired
    private JouetRepository jouetRepository;

    public JouetService(JouetRepository jouetRepository) {
        super(jouetRepository);
        this.jouetRepository = jouetRepository;
    }

    @Override
    protected JouetDtoSend mapToResponse(Jouet jouet) {
        return JouetDtoSend.builder()
                .id_jouet(jouet.getId_jouet())
                .nom(jouet.getNom())
                .description(jouet.getDescription())
                .prix(jouet.getPrix())
                .build();
    }

    @Override
    protected Jouet mapToEntity(JouetDtoReceive dto) {
        return Jouet.builder()
                .nom(dto.getNom())
                .description(dto.getDescription())
                .prix(dto.getPrix())
                .build();
    }

    @Override
    public String getEntityName() {
        return "Jouet";
    }
}
