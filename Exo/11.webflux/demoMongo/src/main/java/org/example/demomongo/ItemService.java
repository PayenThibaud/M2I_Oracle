package org.example.demomongo;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Flux<Item> findAll() {
        return itemRepository.findAll();
    }

    public Mono<Item> save(Item item) {
        return itemRepository.save(item);
    }

    public Mono<Item> findById(String id) {
        return itemRepository.findById(id);
    }

    public Mono<Item> updateItem(String id, Item item) {
        return itemRepository.findById(id)
                .flatMap(i -> {
                    i.setName(item.getName());
                    i.setDescription(item.getDescription());
                    i.setPrice(item.getPrice());
                    return itemRepository.save(i);
                });
    }

    public Mono<Void> deleteItem(String id) {
        return itemRepository.deleteById(id);
    }
}
