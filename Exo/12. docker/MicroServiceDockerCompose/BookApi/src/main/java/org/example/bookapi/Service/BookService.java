package org.example.bookapi.Service;

import org.example.bookapi.Dto.AuteurDtoSend;
import org.example.bookapi.Dto.BookDtoReceive;
import org.example.bookapi.Dto.BookDtoSend;
import org.example.bookapi.Dto.BookDtoSendGet;
import org.example.bookapi.Entity.Book;
import org.example.bookapi.Repository.BookRepository;
import org.example.bookapi.Utils.RestClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService extends GeneriqueServiceImpl<BookDtoReceive, BookDtoSend, Book> {

    private final BookRepository bookRepository;

    public BookService( BookRepository bookRepository) {
        super(bookRepository);
        this.bookRepository = bookRepository;
    }

    @Override
    protected BookDtoSend mapToResponse(Book book) {
        return BookDtoSend.builder()
                .id_book(book.getId_book())
                .titre(book.getTitre())
                .id_auteur(book.getIdAuteur())
                .build();
    }

    @Override
    protected Book mapToEntity(BookDtoReceive dto) {
        return Book.builder()
                .titre(dto.getTitre())
                .idAuteur(dto.getId_auteur())
                .build();
    }

    @Override
    public String getEntityName() {
        return "book";
    }

    private void rechercherNomAuteur(List<BookDtoSendGet> bookDtoSendGets) {
        for (BookDtoSendGet book : bookDtoSendGets) {
            RestClient<AuteurDtoSend> auteurRestClient = new RestClient<>("http://auteur-api:" + 8082 + "/auteur/" + book.getId_auteur());

            try {
                AuteurDtoSend auteurDtoResponse = auteurRestClient.getRequest(AuteurDtoSend.class);
                book.setAuteur_nom(auteurDtoResponse.getNom());
            } catch (Exception e) {
                System.err.println("Erreur, du service auteur pour la matière avec l'ID " + book.getId_auteur());
                e.printStackTrace();
                book.setAuteur_nom("Nom indisponible");
            }
        }
    }

    public List<BookDtoSendGet> getBookWithNomAuteur() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        List<BookDtoSendGet> bookDtoSendGets = books.stream()
                .map(book -> BookDtoSendGet.builder()
                        .id_book(book.getId_book())
                        .titre(book.getTitre())
                        .id_auteur(book.getIdAuteur())
                        .build())
                .toList();

        rechercherNomAuteur(bookDtoSendGets);
        return bookDtoSendGets;
    }
}
