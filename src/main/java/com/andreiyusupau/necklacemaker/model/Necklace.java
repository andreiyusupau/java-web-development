package com.andreiyusupau.necklacemaker.model;

import java.util.List;

public class Necklace {

    private final List<Gem> gems;

    public Necklace(List<Gem> gems) {
        this.gems = gems;
    }

    public List<Gem> getGems() {
        return gems;
    }
}
