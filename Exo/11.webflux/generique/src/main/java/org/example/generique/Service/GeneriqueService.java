package org.example.generique.Service;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class GeneriqueService<T, ID> implements IGeneriqueService<T, ID> {

    protected final ReactiveCrudRepository<T, ID> repository;

    public GeneriqueService(ReactiveCrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public Flux<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public Mono<T> save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Mono<T> update(ID id, T newEntity) {
        return repository.findById(id).flatMap(entity -> {
            try {
                for (var newField : newEntity.getClass().getDeclaredFields()) {
                    newField.setAccessible(true);

                    Object newValue = newField.get(newEntity);

                    if (newField.getName().equals("id") || newValue == null) {
                        continue;
                    }

                    var entityField = entity.getClass().getDeclaredField(newField.getName());
                    entityField.setAccessible(true);
                    entityField.set(entity, newValue);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                return Mono.error(new RuntimeException("Erreur lors de la mise à jour des champs : " + e.getMessage(), e));
            }
            return repository.save(entity);
        });
    }


    @Override
    public Mono<Void> deleteById(ID id) {
        return repository.deleteById(id);
    }
}
