package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean isExist = false;

        Map<String, FiltreProduit> filtres = new HashMap<>();
        filtres.put("quantite", produit -> produit.getQuantite() <= 0);
        final String[] nomRecherche = {""};
        filtres.put("nom", produit -> produit.getNom().equalsIgnoreCase(nomRecherche[0]));


        Map<String, OperationProduit> operations = new HashMap<>();
        operations.put("augmentation", produit -> {
            System.out.print("Entrez l'augmentation : ");
            int augmentation = scanner.nextInt();
            scanner.nextLine();
            produit.setPrix(produit.getPrix() + augmentation);
            return produit;
        });

        operations.put("reduction", produit -> {
            System.out.print("Entrez la réduction : ");
            int reduction = scanner.nextInt();
            scanner.nextLine();
            produit.setPrix(produit.getPrix() - reduction);
            return produit;
        });

        operations.put("stockUp", produit -> {
            System.out.print("Entrez le rajout au stock : ");
            int ajout = scanner.nextInt();
            scanner.nextLine();
            produit.setQuantite(produit.getQuantite() + ajout);
            return produit;
        });

        operations.put("stockDown", produit -> {
            System.out.print("Entrez le retrait au stock : ");
            int retrait = scanner.nextInt();
            scanner.nextLine();
            produit.setQuantite(produit.getQuantite() - retrait);
            return produit;
        });

        operations.put("changementNom", produit -> {
            System.out.print("Entrez le nouveau nom : ");
            String nom = scanner.nextLine();
            produit.setNom(nom);
            return produit;
        });

        Map<String, TransformationProduit> transformations = new HashMap<>();
        transformations.put("produit", produit -> {
            operations.get("reduction").operation(produit);
            operations.get("changementNom").operation(produit);
            return produit;
        });


        Produit produit1 = new Produit("Patate", 100, 1000);
        Produit produit2 = new Produit("Carotte", 50, 0);
        Produit produit3 = new Produit("Tomate", 200, 500);

        List<Produit> produits = List.of(produit1, produit2, produit3);

        boolean boucle = true;

        while (boucle) {
            System.out.println("Choisissez un filtre :");
            System.out.println("1. Quitter");
            System.out.println("2. Filtrer par nom");
            System.out.println("3. Filtrer par quantiter nul");
            System.out.println("4. Augmenter le prix d un produit");
            System.out.println("5. Reduire le prix d un produit");
            System.out.println("6. Rajouter du stock d un produit");
            System.out.println("7. Reduire du stock d un produit");
            System.out.println("8. Changement de nom + Reduction");
            System.out.println("9. get all");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("Bye");
                    boucle = false;
                    break;

                case 2:
                    System.out.print("Entrez un nom de produit : ");
                    nomRecherche[0] = scanner.nextLine();

                    for (Produit produit : produits) {
                        if (filtres.get("nom").filtreProduit(produit)) {
                            System.out.println("On retrouve bien le nom : " + produit.getNom());
                        }
                    }

                    break;

                case 3:

                    for (Produit produit : produits) {
                        if (filtres.get("quantite").filtreProduit(produit)) {
                            System.out.println(produit.getNom() + " n'a pas de stock.");
                        }
                    }

                    break;

                case 4:
                    System.out.print("Entrez un nom de produit : ");
                    nomRecherche[0] = scanner.nextLine();

                    for (Produit produit : produits) {
                        if (filtres.get("nom").filtreProduit(produit)) {
                            operations.get("augmentation").operation(produit);
                            System.out.println("Prix " + produit.getPrix() + " de " + produit.getNom());

                            isExist = true;
                        }
                    }
                    if (!isExist) {
                        System.out.println("Aucun produit avec ce nom");
                    }


                    break;

                case 5:
                    System.out.print("Entrez un nom de produit : ");
                    nomRecherche[0] = scanner.nextLine();


                    for (Produit produit : produits) {
                        if (filtres.get("nom").filtreProduit(produit)) {
                            operations.get("reduction").operation(produit);
                            System.out.println("Prix " + produit.getPrix() + " de " + produit.getNom());
                            isExist = true;
                        }
                    }
                    if (!isExist) {
                        System.out.println("Aucun produit avec ce nom");
                    }


                    break;

                case 6:
                    System.out.print("Entrez un nom de produit : ");
                    nomRecherche[0] = scanner.nextLine();

                    for (Produit produit : produits) {
                        if (filtres.get("nom").filtreProduit(produit)) {
                            operations.get("stockUp").operation(produit);
                            System.out.println("Quantiter " + produit.getQuantite() + " de " + produit.getNom());
                            isExist = true;
                        }
                    }
                    if (!isExist) {
                        System.out.println("Aucun produit avec ce nom");
                    }


                    break;

                case 7:
                    System.out.print("Entrez un nom de produit : ");
                    nomRecherche[0] = scanner.nextLine();

                    for (Produit produit : produits) {
                        if (filtres.get("nom").filtreProduit(produit)) {
                            operations.get("stockDown").operation(produit);
                            System.out.println("Quantiter " + produit.getQuantite() + " de " + produit.getNom());
                            isExist = true;
                        }
                    }
                    if (!isExist) {
                        System.out.println("Aucun produit avec ce nom");
                    }


                    break;

                case 8:
                    System.out.print("Entrez un nom de produit : ");
                    nomRecherche[0] = scanner.nextLine();

                    for (Produit produit : produits) {
                        if (filtres.get("nom").filtreProduit(produit)) {
                            transformations.get("produit").transform(produit);
                            System.out.println("Prix " + produit.getPrix() + " de " + produit.getNom());
                            isExist = true;
                        }
                    }
                    if (!isExist) {
                        System.out.println("Aucun produit avec ce nom");
                    }


                    break;

                case 9:

                    for (Produit produit : produits) {
                        System.out.println(produit.getNom() + ", prix : " + produit.getPrix() + ", quantiter : " + produit.getQuantite());
                    }


                    break;

                default:
                    System.out.println("Erreur, recommence");
            }
        }
    }
}
