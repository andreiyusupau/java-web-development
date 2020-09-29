package com.andreiyusupau.necklacemaker.service;

import com.andreiyusupau.necklacemaker.model.Gem;
import com.andreiyusupau.necklacemaker.model.Necklace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NecklaceCalculatorTest {

    private final NecklaceCalculator necklaceCalculator = new NecklaceCalculator();

    @Test
    void testCalculatePriceShouldReturnPriceEqualTen() {
        final NecklaceBuilder necklaceBuilder = new NecklaceBuilder();
        necklaceBuilder.addGem(new Gem(Gem.GemType.RUBY, 2, new BigDecimal("1.2")));
        necklaceBuilder.addGem(new Gem(Gem.GemType.SAPPHIRE, 2, new BigDecimal("3.3")));
        necklaceBuilder.addGem(new Gem(Gem.GemType.DIAMOND, 2, new BigDecimal("1.1")));
        necklaceBuilder.addGem(new Gem(Gem.GemType.EMERALD, 2, new BigDecimal("0.5")));
        necklaceBuilder.addGem(new Gem(Gem.GemType.AMETHYST, 2, new BigDecimal("3.9")));
        Necklace necklace = necklaceBuilder.build();
        BigDecimal price = necklaceCalculator.calculatePrice(necklace);
        Assertions.assertEquals(new BigDecimal("10.0"), price);
    }

    @Test
    void testCalculatePriceShouldReturnPriceEqualZero() {
        final NecklaceBuilder necklaceBuilder = new NecklaceBuilder();
        Necklace necklace = necklaceBuilder.build();
        BigDecimal price = necklaceCalculator.calculatePrice(necklace);
        Assertions.assertEquals(BigDecimal.ZERO, price);
    }

    @Test
    void testCalculateMassShouldReturnMassEqualThirtyTwo() {
        final NecklaceBuilder necklaceBuilder = new NecklaceBuilder();
        necklaceBuilder.addGem(new Gem(Gem.GemType.RUBY, 2.2, new BigDecimal("1.2")));
        necklaceBuilder.addGem(new Gem(Gem.GemType.SAPPHIRE, 7.8, new BigDecimal("3.3")));
        necklaceBuilder.addGem(new Gem(Gem.GemType.DIAMOND, 4.3, new BigDecimal("1.1")));
        necklaceBuilder.addGem(new Gem(Gem.GemType.EMERALD, 11.5, new BigDecimal("0.5")));
        necklaceBuilder.addGem(new Gem(Gem.GemType.AMETHYST, 6.2, new BigDecimal("3.9")));
        Necklace necklace = necklaceBuilder.build();
        double mass = necklaceCalculator.calculateMass(necklace);
        Assertions.assertEquals(32.0, mass, 5 * Math.ulp(mass));
    }

    @Test
    void testCalculateMassShouldReturnMassEqualZero() {
        final NecklaceBuilder necklaceBuilder = new NecklaceBuilder();
        Necklace necklace = necklaceBuilder.build();
        double mass = necklaceCalculator.calculateMass(necklace);
        Assertions.assertEquals(0.0, mass, 5 * Math.ulp(mass));
    }
}
