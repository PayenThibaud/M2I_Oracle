package org.example;

@FunctionalInterface
public interface TransformationProduit {
    Produit transform(Produit produit);
}
