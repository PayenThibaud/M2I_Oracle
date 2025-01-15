package org.example.classeservice.Service.Generique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class GeneriqueServiceImpl<Request, Response, Entity> implements IGeneriqueService<Request, Response> {

    protected JpaRepository<Entity, Integer> repository;

    protected abstract Response mapToResponse(Entity entity);

    protected abstract Entity mapToEntity(Request dto);

    @Override
    public List<Response> getAllEntities() {
        List<Entity> entities = repository.findAll();
        return entities.stream().map(this::mapToResponse).toList();
    }

    @Override
    public Response getEntityById(int id) {
        Entity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
        return mapToResponse(entity);
    }

    @Override
    public Response createEntity(Request dto) {
        Entity entity = mapToEntity(dto);
        Entity savedEntity = repository.save(entity);
        return mapToResponse(savedEntity);
    }

    @Override
    public Response updateEntity(int id, Request dto) {
        Entity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
        Entity updatedEntity = mapToEntity(dto);
        // Si nécessaire, on peut copier des données de l'entité existante vers l'entité mise à jour
        updatedEntity = repository.save(updatedEntity);
        return mapToResponse(updatedEntity);
    }

    @Override
    public void deleteEntity(int id) {
        Entity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
        repository.delete(entity);
    }
}
