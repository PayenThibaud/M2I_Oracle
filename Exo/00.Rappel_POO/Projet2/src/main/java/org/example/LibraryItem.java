package org.example;

public abstract class LibraryItem {

    int id;
    String title;
    int publicationYear;

    public LibraryItem(int id, String title, int publicationYear) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public abstract String getDetails();

}
