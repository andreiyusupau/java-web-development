package com.adnreiyusupau.busdepot.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public final class Route {
    private final LinkedList<BusStop> busStops=new LinkedList<>();

    public void addStop(BusStop busStop){
        busStops.add(busStop);
    }

    public void addStops(BusStop ... addedBusStops){
        busStops.addAll(Arrays.asList(addedBusStops));
    }

public Iterator<BusStop> getIterator(){
       return busStops.iterator();
}
}
