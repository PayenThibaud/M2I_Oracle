package org.example;

public class Book extends LibraryItem {
    String author;
    String genre;

    public Book(String author, String genre, int id, String title, int publicationYear ) {
        super(id, title, publicationYear);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String getDetails() {
        return "Book : " + title + ", " + author + ", " + genre + ", " + publicationYear + ", " + id;
    }
}
