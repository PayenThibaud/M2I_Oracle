package org.example.bookapi.Controller;

import org.example.bookapi.Dto.BookDtoReceive;
import org.example.bookapi.Dto.BookDtoSend;
import org.example.bookapi.Dto.BookDtoSendGet;
import org.example.bookapi.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 POST http://localhost:8081/book
 Content-Type: application/json

 {
 "titre": "0123456789",
 "id_auteur": 2
 }
 */

@RestController
@RequestMapping("book")
public class BookController extends GeneriqueController<BookDtoReceive, BookDtoSend, BookService> {
    public BookController(BookService service) {
        super(service);
    }

    @GetMapping("/agregation_nom_auteur")
    public ResponseEntity<List<BookDtoSendGet>> getBooksWithAuthorNames() {
        List<BookDtoSendGet> booksWithAuthors = service.getBookWithNomAuteur();
        return ResponseEntity.ok(booksWithAuthors);
    }
}
