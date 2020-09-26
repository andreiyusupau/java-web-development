package com.andreiyusupau.necklacemaker.dao;

import com.andreiyusupau.necklacemaker.model.Gem;

import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class ConsoleGemDAO implements DAO<Gem> {

    @Override
    public Gem get() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FilterInputStream(System.in) {
            @Override
            public void close() throws IOException {
                //prevent closing System.in
            }
        }))) {
            System.out.println("Please, choose the type of the gem:");
            System.out.println("Gems available:");

            for (Gem.GemType gem : Gem.GemType.values()) {
                System.out.println(gem.toString());
            }

            Gem.GemType gemType;


            while (true) {
                String gemTypeInput = bufferedReader.readLine()
                        .toUpperCase();
                boolean gemTypeExists = false;
                for (Gem.GemType gem : Gem.GemType.values()) {
                    if (gemTypeInput.equals(gem.toString().toUpperCase())) {
                        gemTypeExists = true;
                        break;
                    }
                }
                if (gemTypeExists) {
                    gemType = Gem.GemType.valueOf(gemTypeInput);
                    break;
                } else {
                    System.err.println("Please enter the valid gem type, type " + gemTypeInput + " does not exist.");
                }
            }

            double gemMass;
            System.out.println("Please, input the gem mass(in carats):");
            while (true) {
                String gemMassInput = bufferedReader.readLine();
                if (gemMassInput.matches("\\d{1,9}(\\.\\d{1,9})?")) {
                    gemMass = Double.parseDouble(gemMassInput);
                    if (gemMass > 0) {
                        break;
                    } else {
                        System.err.println("Gem mass should be higher than zero.");
                    }
                } else {
                    System.err.println("Enter a number!");
                }
            }

            BigDecimal gemPrice;
            System.out.println("Please, input the gem price(in USD):");
            while (true) {
                String gemPriceInput = bufferedReader.readLine();
                if (gemPriceInput.matches("\\d{1,9}(\\.\\d{1,9})?")) {
                    gemPrice = new BigDecimal(gemPriceInput);
                    if (gemPrice.compareTo(BigDecimal.ZERO) > 0) {
                        break;
                    } else {
                        System.err.println("Gem price should be higher than zero.");
                    }
                } else {
                    System.err.println("Enter a number!");
                }
            }
            return new Gem(gemType, gemMass, gemPrice);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
