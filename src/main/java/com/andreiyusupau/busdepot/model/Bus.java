package com.andreiyusupau.busdepot.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public final class Bus implements Runnable {

    private final Route route;
    private final Set<Passenger> passengers=new HashSet<>();
    private final ReentrantLock doors=new ReentrantLock();
    private BusStop currentBusStop;
    private static final Logger LOGGER = LogManager.getLogger(Bus.class);

    public Bus(Route route) {
        this.route = route;
    }

    public Route getRoute() {
        return route;
    }

    public BusStop getCurrentBusStop() {
        return currentBusStop;
    }

    public void enter(Passenger passenger){
        doors.lock();
        try {
            passengers.add(passenger);
            LOGGER.info(passenger+" entered "+this);
        }finally {
            doors.unlock();
        }
    }

    public void leave(Passenger passenger){
        doors.lock();
        try {
            passengers.remove(passenger);
            LOGGER.info(passenger+" left "+this);
        }finally {
            doors.unlock();
        }
    }

    public void ride(){
        doors.lock();
        LOGGER.info(this+" closed the doors");
        try {
            if(currentBusStop!=null){
                currentBusStop.leave();
            }
            currentBusStop=route.getNextStop(currentBusStop);
                TimeUnit.SECONDS
                        .sleep(1);
                currentBusStop.arrive(this);
                LOGGER.info(this+" arrived");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            doors.unlock();
            LOGGER.info(this+" opened the doors");
            passengers.forEach(passenger -> passenger.busArrivedEvent(this));
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
        while (true){
            ride();
        }
    }
}
