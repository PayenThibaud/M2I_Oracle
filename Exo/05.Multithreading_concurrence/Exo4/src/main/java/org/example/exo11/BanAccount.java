package org.example.exo11;

public class BanAccount {
    private double solde;

    public BanAccount(double solde) {
        this.solde = solde;
    }

    public double getSolde() {
        return solde;
    }

    public double deposit(double amount) {
        solde = solde + amount;
        return solde;
    }

    public double withdraw(double amount) {
        if (amount > solde) {
            throw new IllegalArgumentException("solde insuffisant");
        }
        solde = solde - amount;
        return solde;
    }
}
