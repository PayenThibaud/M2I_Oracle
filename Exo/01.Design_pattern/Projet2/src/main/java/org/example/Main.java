package org.example;

public class Main {
    public static void main(String[] args) {

        CurrencyConverter converter = new CurrencyConverter();
        ICurrencyAdapter currencyAdapter = new CurrencyAdapter(converter);

        double resultat1 = currencyAdapter.convert("EUR","USD", 100);
        System.out.println("100 EUR = " + resultat1 + " USD");

        double resultat2 = currencyAdapter.convert("EUR","GBP", 100);
        System.out.println("100 EUR = " + resultat2 + " GBP");



    }
}