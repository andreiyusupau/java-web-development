package com.andreiyusupau.busdepot.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Passenger implements Runnable{

    private final BusStop targetStop;
    private Bus bus;
    private static final Logger LOGGER = LogManager.getLogger(Passenger.class);

    public Passenger(BusStop targetStop) {
        this.targetStop = targetStop;
    }

    public void busArrivedEvent(Bus bus){
        LOGGER.info("Passenger on bus stop notified that bus has arrived");
    if(bus.getRoute()
            .containsStop(targetStop)){
        LOGGER.info("Passenger tries to enter bus");
       this.bus=bus;
     notifyAll();
    }
    }

    public void currentStopEvent(){
        LOGGER.info("Passenger in bus notified that bus has arrived");
    }

    @Override
    public void run() {
        while (bus==null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bus.enter(this);
        while (bus.getCurrentBusStop()!=targetStop){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bus.leave(this);
    }
}
