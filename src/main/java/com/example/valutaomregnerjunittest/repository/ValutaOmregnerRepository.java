package com.example.valutaomregnerjunittest.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ValutaOmregnerRepository {

    public double exchange(String fromCurrency, String toCurrency, double amount){

        double convertedToDKK = valutaTilDanskSwitch(fromCurrency, amount);
        double convertedResult = danskeTilValutaSwitch(toCurrency, convertedToDKK);

        return convertedResult;
    }

    private double danskeTilValutaSwitch(String fromCurrency, double danishAmount) {
        return switch (fromCurrency){
            case "EUR" -> 0.13 * danishAmount;
            case "USD" -> 0.14 * danishAmount;
            case "GRB" -> 0.12 * danishAmount;
            case "DKK" -> 1 * danishAmount;
            default -> throw new IllegalArgumentException("Unknown Valuta.");
        };
    }

    private double valutaTilDanskSwitch(String toCurrency, double amount) {
        return switch (toCurrency){
            case "EUR" -> 7.44 * amount;
            case "USD" -> 7.18 * amount;
            case "GRB" -> 8.53 * amount;
            case "DKK" -> 1 * amount;
            default -> throw new IllegalArgumentException("Unknown Valuta.");
        };
    }


}
