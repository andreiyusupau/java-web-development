package com.andreiyusupau.necklacemaker.model;

import java.math.BigDecimal;

public class Gem {

    private final GemType gemType;
    private final double mass;
    private final BigDecimal price;

    public Gem(GemType gemType, double mass, BigDecimal price) {
        this.gemType = gemType;
        this.mass = mass;
        this.price = price;
    }

    public GemType getGemType() {
        return gemType;
    }

    public double getMass() {
        return mass;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public enum GemType {
        DIAMOND,
        RUBY,
        SAPPHIRE,
        EMERALD,
        AMETHYST;

        @Override
        public String toString() {
            return this.name().toLowerCase();
        }
    }
}
