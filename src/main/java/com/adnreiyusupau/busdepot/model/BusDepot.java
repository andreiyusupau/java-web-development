package com.adnreiyusupau.busdepot.model;

public final class BusDepot {

    private static final BusDepot INSTANCE=new BusDepot();

    private BusDepot(){
       throw new AssertionError();
    }

    public BusDepot getInstance(){
        return INSTANCE;
    }
}
