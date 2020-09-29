package com.andreiyusupau.necklacemaker.service;

import com.andreiyusupau.necklacemaker.model.Gem;
import com.andreiyusupau.necklacemaker.model.Necklace;

import java.math.BigDecimal;

public class NecklaceCalculator {

    public double calculateMass(Necklace necklace){
        double totalMass=0.0;
        for(Gem gem:necklace.getGems()){
            totalMass+=gem.getMass();
        }
        return totalMass;
    }

    public BigDecimal calculatePrice(Necklace necklace){
        BigDecimal totalPrice= new BigDecimal(0);
        for(Gem gem:necklace.getGems()){
            totalPrice=totalPrice.add(gem.getPrice());
        }
        return totalPrice;
    }
}
