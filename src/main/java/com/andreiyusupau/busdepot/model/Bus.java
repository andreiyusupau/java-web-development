package com.andreiyusupau.busdepot.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public final class Bus implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(Bus.class);
    private final Route route;
    private final Set<Passenger> passengers = new HashSet<>();
    private final ReentrantLock doors = new ReentrantLock();
    private BusStop currentBusStop;
    private boolean riding = true;

    public Bus(Route route) {
        this.route = route;
    }

    public boolean isRiding() {
        return riding;
    }

    public void setRiding(boolean riding) {
        this.riding = riding;
    }

    public Route getRoute() {
        return route;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public BusStop getCurrentBusStop() {
        return currentBusStop;
    }

    public void enter(Passenger passenger) {
        doors.lock();
        try {
            passengers.add(passenger);
            LOGGER.info(passenger + " entered " + this);
        } finally {
            doors.unlock();
        }
    }

    public void leave(Passenger passenger) {
        doors.lock();
        try {
            passengers.remove(passenger);
            LOGGER.info(passenger + " left " + this);
        } finally {
            doors.unlock();
        }
    }

    public void ride() {
        doors.lock();
        LOGGER.info(this + " closed the doors");
        try {
            if (currentBusStop != null) {
                currentBusStop.leave(this);
                LOGGER.info(this + " left the " + currentBusStop);
            }
            currentBusStop = route.getNextStop(currentBusStop);
            TimeUnit.SECONDS
                    .sleep(1);
            currentBusStop.arrive(this);
            LOGGER.info(this + " arrived at " + currentBusStop);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            passengers.forEach(Passenger::currentStopEvent);
            doors.unlock();
            LOGGER.info(this + " opened the doors");
            try {
                TimeUnit.SECONDS
                        .sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (riding || !passengers.isEmpty()) {
            ride();
        }
    }
}
