package com.andreiyusupau.necklacemaker.service;

import com.andreiyusupau.necklacemaker.model.Gem;
import com.andreiyusupau.necklacemaker.model.Necklace;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NecklaceBuilder {

    private final List<Gem> gems= new ArrayList<>();

    public NecklaceBuilder addGem(Gem gem){
        gems.add(gem);
        return this;
    }

    public NecklaceBuilder addGem(String gemType, double mass, double price){
        gems.add(new Gem(Gem.GemType.valueOf(gemType),mass, BigDecimal.valueOf(price)));
        return this;
    }

    public NecklaceBuilder addGems(Collection<Gem> gems){
        this.gems.addAll(gems);
        return this;
    }

    public Necklace build(){
        Necklace necklace= new Necklace(gems);
        gems.clear();
        return necklace;
    }
}
