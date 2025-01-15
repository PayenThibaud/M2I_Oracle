package org.example.gateway.Controller.Generique;

import org.example.gateway.DTO.Classe.ClasseDTORequest;
import org.example.gateway.DTO.Classe.ClasseDTOResponse;
import org.example.gateway.DTO.Classe.ClasseDTOResponseGet;
import org.example.gateway.utils.PortAPI;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("classe")
public class ClasseControllerUseGenerique extends GeneriqueController<ClasseDTORequest, ClasseDTOResponse, ClasseDTOResponseGet> {

    @Override
    protected String getBaseUrl() {
        return "http://localhost:" + PortAPI.portClasse + "/classe";
    }

    @Override
    protected String getEntityName() {
        return "Classe";
    }

    @Override
    protected Class<ClasseDTOResponseGet[]> getArrayResponseType() {
        return ClasseDTOResponseGet[].class;
    }

    @Override
    protected Class<ClasseDTOResponseGet> getSingleResponseTypeGet() {
        return ClasseDTOResponseGet.class;
    }

    @Override
    protected Class<ClasseDTOResponse> getSingleResponseType() {
        return ClasseDTOResponse.class;
    }
}
