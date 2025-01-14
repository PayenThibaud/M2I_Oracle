package org.example.matiereservice.Service;

import jakarta.persistence.EntityNotFoundException;
import org.example.matiereservice.Dto.MatiereDtoReceive;
import org.example.matiereservice.Dto.MatiereDtoSend;
import org.example.matiereservice.Entity.Matiere;
import org.example.matiereservice.Repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {

    @Autowired
    private MatiereRepository matiereRepository;

    public MatiereService(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }

    private MatiereDtoSend matiereMapperMatiereDtoSend(Matiere matiere) {
        return MatiereDtoSend.builder()
                .id_matiere(matiere.getId_matiere())
                .nom(matiere.getNom())
                .coeficient(matiere.getCoeficient())
                .id_Prof(matiere.getIdProf())
                .build();
    }

    private List<MatiereDtoSend> listeMatiereMapperMatiereDtoSend(List<Matiere> matieres) {
        return matieres.stream().map(this::matiereMapperMatiereDtoSend).toList();
    }

    private Matiere findMatiereById(int idMatiere) {
        return matiereRepository.findById(idMatiere).orElseThrow(() -> new EntityNotFoundException("Matiere introuvable avec l'ID : " + idMatiere));
    }

    public MatiereDtoSend getByIdMatiere(int idMatiere) {
        return matiereMapperMatiereDtoSend(findMatiereById(idMatiere));
    }

    public List<MatiereDtoSend> getAllMatieres() {
        return listeMatiereMapperMatiereDtoSend((List<Matiere>) matiereRepository.findAll());
    }

    public List<MatiereDtoSend> getMatieresByProf(int idProf) {
        return listeMatiereMapperMatiereDtoSend((matiereRepository.findByIdProf(idProf)));
    }

    public MatiereDtoSend saveMatiere(MatiereDtoReceive matiereDtoReceive) {
        Matiere matiere = Matiere.builder()
                .coeficient(matiereDtoReceive.getCoeficient())
                .nom(matiereDtoReceive.getNom())
                .idProf(matiereDtoReceive.getId_Prof())
                .build();

        return matiereMapperMatiereDtoSend(matiereRepository.save(matiere));
    }

    public MatiereDtoSend updateMatiere(int id, MatiereDtoReceive matiereDtoReceive) {
        Matiere matiere = findMatiereById(id);

        matiere.setNom(matiereDtoReceive.getNom());
        matiere.setCoeficient(matiereDtoReceive.getCoeficient());
        matiere.setIdProf(matiereDtoReceive.getId_Prof());

        return matiereMapperMatiereDtoSend(matiereRepository.save(matiere));
    }
}
