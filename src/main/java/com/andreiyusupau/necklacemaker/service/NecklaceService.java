package com.andreiyusupau.necklacemaker.service;

import com.andreiyusupau.necklacemaker.dao.DAO;
import com.andreiyusupau.necklacemaker.model.Gem;
import com.andreiyusupau.necklacemaker.model.Necklace;

public class NecklaceService {

    private final NecklaceBuilder necklaceBuilder;
    private final DAO<Gem> gemDAO;

    public NecklaceService(NecklaceBuilder necklaceBuilder, DAO<Gem> gemDAO) {
        this.necklaceBuilder = necklaceBuilder;
        this.gemDAO = gemDAO;
    }

    public void addGem() {
        Gem gem = gemDAO.get();
        necklaceBuilder.addGem(gem);
    }

    public Necklace createNecklace() {
        return necklaceBuilder.build();
    }
}
