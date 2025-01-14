package org.example.matiereservice.Service;

import jakarta.persistence.EntityNotFoundException;
import org.example.matiereservice.Dto.Matiere.MatiereDtoReceive;
import org.example.matiereservice.Dto.Matiere.MatiereDtoSend;
import org.example.matiereservice.Dto.Matiere.MatiereDtoSendGet;
import org.example.matiereservice.Dto.Prof.ProfDtoSend;
import org.example.matiereservice.Entity.Matiere;
import org.example.matiereservice.Repository.MatiereRepository;
import org.example.matiereservice.tools.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MatiereService {

    @Autowired
    private MatiereRepository matiereRepository;

    public MatiereService(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }

    private void rechercherNomProf(List<MatiereDtoSendGet> matiereDtoSendGets) {
        for (MatiereDtoSendGet matiere : matiereDtoSendGets) {
            RestClient<ProfDtoSend> profRestClient = new RestClient<>("http://localhost:" + 8082 + "/prof/" + matiere.getId_Prof());

            try {
                ProfDtoSend profDtoResponse = profRestClient.getRequest(ProfDtoSend.class);
                matiere.setNomProf(profDtoResponse.getNom());
            } catch (Exception e) {
                System.err.println("Erreur, du service professeur pour la matière avec l'ID " + matiere.getId_Prof());
                e.printStackTrace();
                matiere.setNomProf("Nom indisponible");
            }
        }
    }


    private MatiereDtoSendGet agregationMatiereDtoSendGet(Matiere matiere) {
        return MatiereDtoSendGet.builder()
                .id_matiere(matiere.getId_matiere())
                .nom(matiere.getNom())
                .coeficient(matiere.getCoeficient())
                .id_Prof(matiere.getIdProf())
                .build();
    }

    private List<MatiereDtoSendGet> agregationListMatieresProfName(List<Matiere> matieres) {

        List<MatiereDtoSendGet> matiereDtoSendGets = matieres.stream()
                .map(this::agregationMatiereDtoSendGet)
                .toList();

        rechercherNomProf(matiereDtoSendGets);
        return matiereDtoSendGets;
    }


    private MatiereDtoSend matiereMapperMatiereDtoSend(Matiere matiere) {
        return MatiereDtoSend.builder()
                .id_matiere(matiere.getId_matiere())
                .nom(matiere.getNom())
                .coeficient(matiere.getCoeficient())
                .id_Prof(matiere.getIdProf())
                .build();
    }

    private Matiere findMatiereById(int idMatiere) {
        return matiereRepository.findById(idMatiere).orElseThrow(() -> new EntityNotFoundException("Matiere introuvable avec l'ID : " + idMatiere));
    }

    public MatiereDtoSendGet getByIdMatiere(int idMatiere) {
        Matiere matiere = findMatiereById(idMatiere);
        List<MatiereDtoSendGet> resultList = agregationListMatieresProfName(Arrays.asList(matiere));
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    public List<MatiereDtoSendGet> getAllMatieres() {
        List<Matiere> matieres = (List<Matiere>) matiereRepository.findAll();
        return agregationListMatieresProfName(matieres);
    }

    public List<MatiereDtoSendGet> getMatieresByProf(int idProf) {
        List<Matiere> matieres = matiereRepository.findByIdProf(idProf);
        return agregationListMatieresProfName(matieres);
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

    public void deleteMatiere(int id) {
        matiereRepository.deleteById(id);
    }
}
