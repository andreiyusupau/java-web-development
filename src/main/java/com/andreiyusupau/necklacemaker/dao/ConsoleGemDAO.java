package com.andreiyusupau.necklacemaker.dao;

import com.andreiyusupau.necklacemaker.model.Gem;

import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class ConsoleGemDAO implements DAO<Gem> {

    private static final String POSITIVE_DOUBLE_REGEX="\\d{1,9}(\\.\\d{1,9})?";

    @Override
    public Gem get() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FilterInputStream(System.in) {
            @Override
            public void close() {
                //prevent closing System.in
            }
        }))) {
            System.out.println("Please, choose the type of the gem:");
            System.out.println("Gems available:");
            for (Gem.GemType gem : Gem.GemType.values()) {
                System.out.println(gem.toString());
            }

            Gem.GemType gemType = readGemType(bufferedReader);

            System.out.println("Please, input the gem mass(in carats):");
            double gemMass = readMass(bufferedReader);

            System.out.println("Please, input the gem price(in USD):");
            BigDecimal gemPrice=readPrice(bufferedReader);

            return new Gem(gemType, gemMass, gemPrice);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Gem.GemType readGemType(BufferedReader bufferedReader) throws IOException {

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
                return Gem.GemType.valueOf(gemTypeInput);
            } else {
                System.err.println("Please enter the valid gem type, type " + gemTypeInput + " does not exist.");
            }
        }
    }

    public double readMass(BufferedReader bufferedReader) throws IOException {
        while (true) {
            String gemMassInput = bufferedReader.readLine();
            if (gemMassInput.matches(POSITIVE_DOUBLE_REGEX)) {
                double gemMass = Double.parseDouble(gemMassInput);
                if (gemMass > 0) {
                    return gemMass;
                } else {
                    System.err.println("Gem mass should be higher than zero.");
                }
            } else {
                System.err.println("Enter a number!");
            }
        }
    }

    public BigDecimal readPrice(BufferedReader bufferedReader) throws IOException {
        while (true) {
            String gemPriceInput = bufferedReader.readLine();
            if (gemPriceInput.matches(POSITIVE_DOUBLE_REGEX)) {
                BigDecimal gemPrice = new BigDecimal(gemPriceInput);
                if (gemPrice.compareTo(BigDecimal.ZERO) > 0) {
                    return gemPrice;
                } else {
                    System.err.println("Gem price should be higher than zero.");
                }
            } else {
                System.err.println("Enter a number!");
            }
        }
    }
}
