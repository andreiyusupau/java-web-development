package com.andreiyusupau.busdepot.service;

import com.andreiyusupau.busdepot.model.Bus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class BusDepot {

    private static final BusDepot INSTANCE = new BusDepot();
    private final List<Bus> buses = new ArrayList<>();
    private ExecutorService busService;

    private BusDepot() {
        //prevent reflective access
        if (INSTANCE != null) {
            throw new AssertionError();
        }
    }

    public static BusDepot getInstance() {
        return INSTANCE;
    }

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public void start() {
        busService = Executors.newFixedThreadPool(buses.size());
        buses.forEach(bus -> busService.execute(bus));
    }

    public void finish(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
            buses.forEach(bus -> bus.setRiding(false));
            busService.shutdown();
            if (!busService.awaitTermination(5, TimeUnit.SECONDS)) {
                busService.shutdownNow();
            }
        } catch (InterruptedException e) {
            busService.shutdownNow();
        }
    }
}
