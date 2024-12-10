package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        List<Film> films = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/films_with_genres 1.csv"))) {
            String next;
            while ((next = br.readLine()) != null) {
                String[] data = next.split(",");
                if (data.length >= 5) {
                    films.add(new Film(data[0], data[1], data[2], data[3], data[4]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        films.remove(0);

        // 1 Lecture et affichage bassique avec streams

        films.stream()
                .limit(10)
                .forEach(f -> System.out.println(f.toString()));

        films.stream()
                .forEach(film -> System.out.println(film.getTitre()));

//        2. Filtrage avec Streams

        films.stream()
                .filter(film -> Objects.equals(film.getGenre(), "Action"))
                .forEach(film -> System.out.println(film.getTitre() + ", " + film.getDate()));

        films.stream()
                .filter(film -> {
                    int year = Integer.parseInt(film.getDate().substring(0, 4));
                    return year >= 2000;
                })
                .forEach(film -> System.out.println(film.getTitre()));

        films.stream()
                .filter(film -> Objects.equals(film.getAuteur(), "Michael Webster"))
                .forEach(film -> System.out.println(film.getTitre() + ", " + film.getAuteur()));


//        3. Tri et limitation avec Streams

        films.stream()
                .sorted((film1, film2) -> Integer.compare(Integer.parseInt(film1.getNbEntree()), Integer.parseInt(film2.getNbEntree())))
                .limit(5)
                .forEach(film -> System.out.println(film.getTitre() + ", " + film.getNbEntree()));

        films.stream()
                .sorted((film1, film2) -> Integer.compare(
                        Integer.parseInt(film1.getDate().substring(8, 10)),
                        Integer.parseInt(film2.getDate().substring(8, 10))
                ))
                .sorted((film1, film2) -> Integer.compare(
                        Integer.parseInt(film1.getDate().substring(5, 7)),
                        Integer.parseInt(film2.getDate().substring(5, 7))
                ))
                .sorted((film1, film2) -> Integer.compare(
                        Integer.parseInt(film1.getDate().substring(0, 4)),
                        Integer.parseInt(film2.getDate().substring(0, 4))
                ))
                .forEach(film -> System.out.println(film.getTitre() + ", " + film.getDate()));

        films.stream()
                .sorted((film1, film2) -> Integer.compare(Integer.parseInt(film1.getNbEntree()), Integer.parseInt(film2.getNbEntree())))
                .limit(10)
                .forEach(film -> System.out.println(film.getTitre() + ", " + film.getNbEntree()));


//        4. Regroupement avec Streams

        films.stream()
                .collect(Collectors.groupingBy(Film::getGenre))
                .forEach((genre, filmsParGenreList) -> {
                    System.out.println("\nGenre : " + genre + " et il y en a " + filmsParGenreList.size());
                    filmsParGenreList.forEach(film -> System.out.println("\t" +film.getTitre() + ", " + film.getNbEntree()));
                });

        films.stream()
                .collect(Collectors.groupingBy(Film::getAuteur))
                .forEach((auteur, filmsParGenreList) -> {
                    System.out.println("\nAuteur : " + auteur + " et il y en a " + filmsParGenreList.size());
                    filmsParGenreList.forEach(film -> System.out.println("\t" +film.getTitre() + ", " + film.getAuteur()));
                });


//        5. Calculs avec Streams

        long totalEntrees = films.stream()
                .mapToInt(film -> Integer.parseInt(film.getNbEntree()))
                .asLongStream()
                .sum();

        System.out.println("Total des entrées : " + totalEntrees);




        Map<String, Long> listTotalEntreesGenre = new HashMap<>();

        films.stream()
                .collect(Collectors.groupingBy(Film::getGenre))
                .forEach((genre, filmsParGenreList) -> {
                    long totalEntreesGenre = filmsParGenreList.stream()
                            .mapToLong(film -> Long.parseLong(film.getNbEntree()))
                            .sum();
                    listTotalEntreesGenre.put(genre ,totalEntreesGenre);
                });

        listTotalEntreesGenre.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .forEach(entry -> System.out.println("Genre : " + entry.getKey() + ", total entrée trié : " + entry.getValue()));



        Map<String, Double> listTotalEntreesAuteur = new HashMap<>();

        films.stream()
                .collect(Collectors.groupingBy(Film::getAuteur))
                .forEach((auteur, filmsParAuteurList) -> {
                    double moyenneEntrees = filmsParAuteurList.stream()
                            .mapToLong(film -> Long.parseLong(film.getNbEntree()))
                            .average()
                            .orElse(0);
                    double moyenneArrondie = Math.round(moyenneEntrees);
                    listTotalEntreesAuteur.put(auteur, moyenneArrondie);
                });

        listTotalEntreesAuteur.entrySet().stream()
                .sorted((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()))
                .forEach(entry -> {
                    long totalArrondi = Math.round(entry.getValue());
                    System.out.println("Auteur : " + entry.getKey() + ", moyenne : " + totalArrondi);
                });


//        6. Transformation avec Streams


        films.stream()
                .collect(Collectors.groupingBy(Film::getGenre))
                .forEach((genre, filmsParGenreList) -> {
                    System.out.println(genre);
                });


//        7. Questions avancées

        films.stream()
                .collect(Collectors.groupingBy(Film::getGenre))
                .forEach((genre, filmsParGenreList) -> {
                    filmsParGenreList.stream()
                            .sorted((film1, film2) -> Integer.compare(
                                    Integer.parseInt(film1.getDate().substring(8, 10)),
                                    Integer.parseInt(film2.getDate().substring(8, 10))
                            ))
                            .sorted((film1, film2) -> Integer.compare(
                                    Integer.parseInt(film1.getDate().substring(5, 7)),
                                    Integer.parseInt(film2.getDate().substring(5, 7))
                            ))
                            .sorted((film1, film2) -> Integer.compare(
                                    Integer.parseInt(film1.getDate().substring(0, 4)),
                                    Integer.parseInt(film2.getDate().substring(0, 4))
                            ))
                            .limit(1)
                            .forEach(film -> System.out.println("Genre : " + genre + ", Film : " + film.getTitre() + ", Date : " + film.getDate()));
                });



        films.stream()
                .collect(Collectors.groupingBy(Film::getAuteur))
                .forEach((auteur, filmsParAuteurList) -> {
                    if(filmsParAuteurList.size()>=50)
                        System.out.println("auteur : " + auteur + "nb films : "+ filmsParAuteurList.size());
                });


        long totalEntreesEntre1998To2000 = films.stream()
                .filter(film -> {
                    int year = Integer.parseInt(film.getDate().substring(0, 4));
                    return year <= 2000 && year >= 1998;
                })
                .mapToInt(film -> Integer.parseInt(film.getNbEntree()))
                .asLongStream()
                .sum();

        System.out.println("Total des entrées entre 2000 et 1998 : " + totalEntreesEntre1998To2000);

    }
}