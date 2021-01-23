package com.andreiyusupau.busdepot.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Passenger implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(Passenger.class);
    private final BusStop targetStop;
    private Bus bus;

    public Passenger(BusStop targetStop) {
        this.targetStop = targetStop;
    }

    public synchronized void busArrivedEvent(Bus bus) {
        LOGGER.info(this + " on bus stop notified that " + bus + " has arrived");
        if (bus.getRoute()
                .containsStop(targetStop)) {
            LOGGER.info(this + " tries to enter bus");
            this.bus = bus;
            notifyAll();
        }
    }

    public synchronized void currentStopEvent() {
        LOGGER.info(this + " in bus notified that bus has arrived at bus stop");
        notifyAll();
    }

    @Override
    public void run() {
        enterBus();
        exitBus();
    }

    public synchronized void enterBus() {
        while (bus == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bus.enter(this);
    }

    public synchronized void exitBus() {
        while (bus.getCurrentBusStop() != targetStop) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bus.leave(this);
    }
}
