package org.example.classeservice.Controller.Generique;

import org.example.classeservice.Dto.ClasseDtoReceive;
import org.example.classeservice.Dto.ClasseDtoSend;
import org.example.classeservice.Service.Generique.ClasseServiceUseGenerique;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("classe")
public class ClasseControllerUseGenerique extends GeneriqueController<ClasseDtoReceive, ClasseDtoSend, ClasseServiceUseGenerique> {

    public ClasseControllerUseGenerique(ClasseServiceUseGenerique classeService) {
        super(classeService);
    }

}