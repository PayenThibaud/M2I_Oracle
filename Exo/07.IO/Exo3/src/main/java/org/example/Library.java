package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private static final String FILE_PATH = "library.ser";
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
        loadLibrary();
    }

    public void startLibrary() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Afficher les livres");
            System.out.println("3. Quitter");
            System.out.print("Choisissez une option : ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    saveLibrary();
                    System.out.println("bye bye");
                    return;
                default:
                    System.out.println("réessaye.");
            }
        }
    }

    private void addBook(Scanner scanner) {
        System.out.print("Entrez le titre du livre : ");
        String title = scanner.nextLine();

        System.out.print("Entrez l'auteur du livre : ");
        String author = scanner.nextLine();

        books.add(new Book(title, author));
        System.out.println("Livre ajouté avec succès !");
    }

    private void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Aucun livre trouvé dans la bibliothèque.");
        } else {
            System.out.println("\nListe des livres :");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void saveLibrary() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(books);
            System.out.println("Bibliothèque sauvegardée avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    private void loadLibrary() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                books = (List<Book>) in.readObject();
                System.out.println("Bibliothèque chargée avec succès !");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erreur lors du chargement : " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.startLibrary();
    }
}
