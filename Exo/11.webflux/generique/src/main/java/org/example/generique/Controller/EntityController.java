package org.example.generique.Controller;

import org.example.generique.Entity.EntityGenerique;
import org.example.generique.Service.EntityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//###
//POST http://localhost:8080/entity
//Content-Type: application/json
//
//{
//    "name": "John Doe",
//        "age": 25.5
//}


@RestController
@RequestMapping("/entity")
public class EntityController extends GeneriqueController<EntityGenerique, Integer> {

    private final EntityService entityService;

    public EntityController( EntityService entityService) {
        super(entityService);
        this.entityService = entityService;
    }
}
