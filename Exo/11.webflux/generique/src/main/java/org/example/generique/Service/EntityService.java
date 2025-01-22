package org.example.generique.Service;

import org.example.generique.Entity.EntityGenerique;
import org.example.generique.Repository.EntityRepository;
import org.springframework.stereotype.Service;

@Service
public class EntityService extends GeneriqueService<EntityGenerique, Integer> {

    private final EntityRepository repository;

    public EntityService(EntityRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
