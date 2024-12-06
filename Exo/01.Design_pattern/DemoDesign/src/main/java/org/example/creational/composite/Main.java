package org.example.creational.composite;

public class Main {
    public static void main(String[] args) {

        Component file = new File("Fichier 1");
        Component file2 = new File("Fichier 2");
        Component file3 = new File("Fichier 3");

        Folder folder = new Folder("Dossier 1");
        Folder folder2 = new Folder("Dossier 2");

        folder2.add(file);
        folder.add(file2);
        folder.add(file3);
        folder.add(folder2);

        folder.operation();

    }
}
