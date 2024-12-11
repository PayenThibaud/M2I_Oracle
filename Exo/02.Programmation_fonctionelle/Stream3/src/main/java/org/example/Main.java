package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Livre> livres = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/books_dataset.csv"))) {
            String next;
            boolean isHeader = true;
            while ((next = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = next.split(",");
                if (data.length >= 7) {
                    try {
                        String titre = data[0];
                        String auteur = data[1];
                        String genre = data[2];
                        LocalDate datePublication = LocalDate.parse(data[3]);
                        int nbPages = Integer.parseInt(data[4]);
                        boolean estDisponible = Boolean.parseBoolean(data[5]);
                        double prix = Double.parseDouble(data[6]);

                        livres.add(new Livre(auteur, genre, titre, datePublication, nbPages, estDisponible, prix));
                    } catch (Exception e) {
                        System.err.println("Error parsing line: " + next);
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        livres.stream()
                .filter(livre -> livre.isEstDisponible())
                .limit(3)
                .forEach(livre -> System.out.println("Livre= " + "Titre : " + livre.getTitre() + " Genre : " + livre.getGenre() + " Auteur : " + livre.getAuteur() ));


        // Pas de livre avant 1900
        livres.stream()
                .filter(livre -> livre.getDatePublication().getYear() < 1950)
                .limit(3)
                .forEach(livre -> System.out.println("Titre: " + livre.getTitre() + ", Date: " + livre.getDatePublication()));


        livres.stream()
                .collect(Collectors.groupingBy(Livre::getGenre))
                .forEach((genre, livresGenre) -> {
                    System.out.println("Genre: " + genre);
                    livresGenre.stream()
                            .limit(2)
                            .forEach(livre -> System.out.println("\tTitre : " + livre.getTitre() + " Auteur : " + livre.getAuteur()));
                });



        livres.stream()
                .sorted((livre1, livre2) -> livre1.getDatePublication().compareTo(livre2.getDatePublication()))
                .limit(1)
                .forEach(livre -> System.out.println("Le livre le plus ancien est : " + livre.getTitre() + ", Date: " + livre.getDatePublication()));



        // Pas de livre avec comme titre Harry
        livres.stream()
                .filter(livre -> livre.getAuteur().contains("Harrys"))
                .forEach(livre -> System.out.println("Titre: " + livre.getTitre() + ", Auteur: " + livre.getAuteur()));



        double prixMoyen = livres.stream()
                .mapToDouble(Livre::getPrix)
                .average()
                .orElse(0.0);

        System.out.println("Le prix moyen est : " + prixMoyen);


        livres.stream()
                .sorted(Comparator.comparingInt(Livre::getNbPages)
                        .thenComparingDouble(Livre::getPrix))
                .limit(5)
                .forEach(livre -> System.out.println("Titre: " + livre.getTitre() + ", Pages: " + livre.getNbPages() + ", Prix: " + livre.getPrix()));



       double nbPageFantasy = livres.stream()
                .filter(livre -> livre.getGenre().equals("Fantasy"))
                .mapToDouble(Livre::getNbPages)
                .sum();

        System.out.println("Le nb pages pour le genre Fantasy est : " + nbPageFantasy);


        livres.stream()
                .filter(Livre::isEstDisponible)
                .sorted(Comparator.comparingDouble(Livre::getPrix).reversed())
                .limit(1)
                .forEach(livre -> System.out.println("Titre: " + livre.getTitre() + ", Pages: " + livre.getNbPages() + ", Prix: " + livre.getPrix()));



        livres.stream()
                .collect(Collectors.groupingBy(Livre::getAuteur))
                .forEach((auteur, livresAuteur) -> {
                    if (livresAuteur.size() > 17) {
                        System.out.println("Auteur: " + auteur);
                        livresAuteur.stream()
                                .limit(2)
                                .forEach(livre ->
                                System.out.println("\tTitre : " + livre.getTitre()));
                    }
                });

        livres.stream()
                .collect(Collectors.groupingBy(Livre::getGenre, Collectors.counting()))
                .forEach((genre, count) -> System.out.println("Genre: " + genre + ", Nombre de livres: " + count));



        livres.stream()
                .filter(Livre::isEstDisponible)
                .filter(livre -> livre.getPrix() < 50)
                .limit(3)
                .forEach(livre -> System.out.println("Titre: " + livre.getTitre() + ", Prix: " + livre.getPrix()));


        livres.stream()
                .collect(Collectors.groupingBy(
                        livre -> livre.getDatePublication().getYear(),
                        Collectors.summingInt(Livre::getNbPages)
                ))
                .forEach((an, totalPage) ->
                        System.out.println("An: " + an + ", Total de page: " + totalPage));



    }
}
