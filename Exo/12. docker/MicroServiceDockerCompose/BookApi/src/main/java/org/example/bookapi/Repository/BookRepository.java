package org.example.bookapi.Repository;

import org.example.bookapi.Entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
