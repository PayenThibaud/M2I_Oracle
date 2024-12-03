package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("ajout des elemnts a la bibliotheque");

        List<LibraryItem> bibliotheque = new ArrayList<>();

        Book book1 = new Book("Titi", "Genre1", 1, "Titre1", 1992);
        Book book2 = new Book("Toto", "Genre2", 2, "Titre2", 1993);

        Magazine magazine1 = new Magazine(1, "Titre1", 1990, 52);
        Magazine magazine2 = new Magazine(2, "Titre2", 1991, 53);

        bibliotheque.add(magazine1);
        bibliotheque.add(magazine2);
        bibliotheque.add(book1);
        bibliotheque.add(book2);

        for (LibraryItem item : bibliotheque) {
            System.out.println(item.getDetails());
        }

        List<BorrowRecord> borrowRecords = new ArrayList<>();
        List<LibraryItem> borrowedItems = new ArrayList<>();

        System.out.println("Emprunt d un element ...");

        BorrowRecord borrowRecord1 = new BorrowRecord(book1.id, "Tutu", LocalDateTime.now().toString());
        borrowRecords.add(borrowRecord1);
        borrowedItems.add(book1);
        bibliotheque.remove(book1);

        for (BorrowRecord borrowRecord : borrowRecords) {
            System.out.println(borrowRecord.toString());
        }

        System.out.println("Liste des elements empruntes :");

        for (LibraryItem item : borrowedItems) {
            System.out.println(item.getDetails());
        }

        System.out.println("Liste des elements disponibles :");

        for (LibraryItem item : bibliotheque) {
            System.out.println(item.getDetails());
        }
    }
}