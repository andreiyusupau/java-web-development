package com.andreiyusupau.busdepot.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public final class BusStop {

    private static final Logger LOGGER = LogManager.getLogger(BusStop.class);
    private final String name;
    private final Set<Passenger> passengers = new HashSet<>();
    private final Semaphore semaphore;

    public BusStop(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    public void leave(Bus bus) {
        LOGGER.info(bus + " leaves " + this);
        passengers.removeAll(bus.getPassengers());
        semaphore.release();
    }

    public void arrive(Bus bus) throws InterruptedException {
        LOGGER.info(bus + " arrives at " + this);
        semaphore.acquire();
        passengers.forEach(passenger -> passenger.busArrivedEvent(bus));
    }

    public void addPassengers(Passenger... addedPassengers) {
        passengers.addAll(Arrays.asList(addedPassengers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusStop busStop = (BusStop) o;
        return !name.equals(busStop.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
