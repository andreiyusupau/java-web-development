package com.andreiyusupau.necklacemaker.service;

import com.andreiyusupau.necklacemaker.model.Gem;
import com.andreiyusupau.necklacemaker.model.Necklace;

import java.util.ArrayList;
import java.util.List;

public class NecklaceBuilder {

    private final List<Gem> gems = new ArrayList<>();

    public void addGem(Gem gem) {
        gems.add(gem);
    }

    public Necklace build() {
       return new Necklace(gems);
    }
}
