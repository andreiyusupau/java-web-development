package com.andreiyusupau.busdepot.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Route {
    private final List<BusStop> busStops=new ArrayList<>();

    public void addStop(BusStop busStop){
        busStops.add(busStop);
    }

    public void addStops(BusStop ... addedBusStops){
        busStops.addAll(Arrays.asList(addedBusStops));
    }

public BusStop getNextStop(BusStop busStop){
        if(busStop==null){
            return busStops.get(0);
        }
        for(int i=0;i<busStops.size();i++){
            if (busStops.get(i)
                    .equals(busStop)){
                return i<busStops.size()-1 ?busStops.get(i+1): busStops.get(0);
            }
        }
        return null;
}

public boolean containsStop(BusStop busStop){
        return busStops.contains(busStop);
}
}
