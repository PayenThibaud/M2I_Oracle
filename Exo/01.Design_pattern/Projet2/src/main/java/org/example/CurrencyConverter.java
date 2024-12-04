package org.example;

public class CurrencyConverter {


    public Double convertToUSD(String Currency, Double amount) {
        if(Currency.equals("EUR")) {
            return amount*1.1;
        }
        if(Currency.equals("GBP")) {
            return amount*1.3;
        }
        return (double) 0;
    }

    public Double convertFromUSD(String Currency, Double amount) {
        if(Currency.equals("EUR")) {
            return amount/1.1;
        }
        if(Currency.equals("GBP")) {
            return amount/1.3;
        }
        return (double) 0;
    }
}
