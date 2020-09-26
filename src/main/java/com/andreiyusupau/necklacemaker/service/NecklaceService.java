package com.andreiyusupau.necklacemaker.service;

import com.andreiyusupau.necklacemaker.dao.DAO;
import com.andreiyusupau.necklacemaker.model.Gem;
import com.andreiyusupau.necklacemaker.model.Necklace;

import java.math.BigDecimal;

public class NecklaceService {

    private final NecklaceBuilder necklaceBuilder;
    private final NecklaceCalculator necklaceCalculator;
    private final DAO<Gem> gemDAO;
    private Necklace necklace;

    public NecklaceService(NecklaceBuilder necklaceBuilder, NecklaceCalculator necklaceCalculator, DAO<Gem> gemDAO) {
        this.necklaceBuilder = necklaceBuilder;
        this.necklaceCalculator = necklaceCalculator;
        this.gemDAO = gemDAO;
    }

    public void addGem() {
        Gem gem = gemDAO.get();
        necklaceBuilder.addGem(gem);
    }

    public void createNecklace() {
        necklace=necklaceBuilder.build();
    }

    public double getNecklaceMass() {
        System.out.println(necklace.getGems().get(0).getMass());
        return necklaceCalculator.calculateMass(necklace);
    }

    public BigDecimal getNecklacePrice() {
        return necklaceCalculator.calculatePrice(necklace);
    }


}
