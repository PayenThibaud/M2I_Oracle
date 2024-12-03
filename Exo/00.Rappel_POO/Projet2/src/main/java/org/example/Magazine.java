package org.example;

public class Magazine extends LibraryItem{

    int issueNumber;

    public Magazine(int id, String title, int publicationYear, int issueNumber) {
        super(id, title, publicationYear);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getDetails() {
        return "Magazine : " + title + ", " + issueNumber + ", " + publicationYear + ", " + id;
    }
}
