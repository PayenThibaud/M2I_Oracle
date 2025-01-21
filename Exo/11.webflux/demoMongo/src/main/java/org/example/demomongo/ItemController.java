package org.example.demomongo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemRepository itemRepository, ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Flux<Item> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<Item>> getItemById(@PathVariable String id) {
        return itemService.findById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<Item> addItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<Item>> updateItem(@PathVariable String id, @RequestBody Item item) {
        return itemService.updateItem(id, item).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<ResponseEntity<Void>> deleteItem(@PathVariable String id) {
        return itemService.deleteItem(id).then(Mono.just(ResponseEntity.noContent().build()));
    }
}
