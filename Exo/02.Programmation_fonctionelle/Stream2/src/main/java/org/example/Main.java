package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Commande> commandes = Arrays.asList(
                new Commande(1, "Alice", Arrays.asList("Ordinateur", "Souris"), 1200.50, true),
                new Commande(2, "Bob", Arrays.asList("Clavier", "Écran"), 300.75, false),
                new Commande(3, "Charlie", Arrays.asList("Imprimante"), 150.00, true),
                new Commande(4, "Alice", Arrays.asList("USB", "Casque"), 75.50, false),
                new Commande(5, "Bob", Arrays.asList("Tablette"), 200.00, true)
        );

        commandes.stream()
                .forEach(commande -> System.out.println(
                        "Commande ID: " + commande.getId() +
                                ", Client: " + commande.getClient() +
                                ", Article: " + commande.getArticles() +
                                ", Montant: " + commande.getMontantTotal() +
                                ", Livree: " + (commande.isEstLivree() ? "Oui" : "Non")
                ));


        commandes.stream()
                .map(Commande::getClient)
                .distinct()
                .forEach(client -> System.out.println("Client: " + client));


        Double Total = commandes.stream()
                .mapToDouble(Commande::getMontantTotal)
                .sum();
        System.out.println("Fortune: " + Total);


        commandes.stream()
                .forEach(commande -> System.out.println(
                        "Article: " + commande.getArticles() +
                                ", Montant: " + commande.getMontantTotal()
                ));


        commandes.stream()
                .filter(commande -> commande.isEstLivree())
                .forEach(commande -> System.out.println(
                        "Commande ID: " + commande.getId() +
                                ", Client: " + commande.getClient() +
                                ", Article: " + commande.getArticles() +
                                ", Montant: " + commande.getMontantTotal() +
                                ", Livree: " + (commande.isEstLivree() ? "Oui" : "Non")
                ));


        Map<String, Double> montantTotalParClient = commandes.stream()
                .collect(Collectors.groupingBy(
                        Commande::getClient,
                        Collectors.summingDouble(Commande::getMontantTotal)
                ));

        montantTotalParClient.forEach((client, montantTotal) ->
                System.out.println("Client: " + client + ", Montant total: " + montantTotal)
        );


        commandes.stream()
                .flatMap(commande -> commande.getArticles().stream())
                .distinct()
                .forEach(article -> System.out.println("Article : " + article));


        Map<String, List<Commande>> commandesParClient = commandes.stream()
                .collect(Collectors.groupingBy(Commande::getClient));

        boolean isToutClientLivree = commandesParClient.entrySet().stream()
                .allMatch(entry -> entry.getValue().stream()
                        .anyMatch(Commande::isEstLivree));

        System.out.println("Tout les clients ont eu au moins une commande livree ? : " + isToutClientLivree);
    }
}