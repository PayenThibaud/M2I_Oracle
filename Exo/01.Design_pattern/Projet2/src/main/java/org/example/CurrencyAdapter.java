package org.example;

import java.util.Currency;

public class CurrencyAdapter implements ICurrencyAdapter {

    private CurrencyConverter currencyConverter;

    public CurrencyAdapter(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    @Override
    public Double convert(String fromCurrency, String toCurrency, double amount) {
        if (fromCurrency.equals("EUR")) {
            if (toCurrency.equals("USD")) {
                return currencyConverter.convertToUSD(fromCurrency, amount);
            } else if (toCurrency.equals("GBP")) {
                return currencyConverter.convertFromUSD(toCurrency,currencyConverter.convertToUSD(fromCurrency, amount));
            }
            return (double) 0;
        }

        if (fromCurrency.equals("GBP")){
            if (toCurrency.equals("USD")) {
                return currencyConverter.convertToUSD(fromCurrency, amount);
            }else if (toCurrency.equals("GBP")) {
                return currencyConverter.convertFromUSD(toCurrency,currencyConverter.convertToUSD(fromCurrency, amount));
            }
            return (double) 0;
        }
        return (double) 0;
    }

}
