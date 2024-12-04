package org.example;

public sealed abstract class LibraryItem permits Book, Magazine{

    protected int id;
    protected String title;
    protected int publicationYear;

    public LibraryItem(int id, String title, int publicationYear) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public abstract String getDetails();

}
