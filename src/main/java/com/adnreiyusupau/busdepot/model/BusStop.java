package com.adnreiyusupau.busdepot.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public final class BusStop {
    private final String name;
    private final Set<Passenger> passengers=new HashSet<>();
    private final Semaphore semaphore;

    public BusStop(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

   public void leave(){
        semaphore.release();
   }

   public void arrive() throws InterruptedException {
        semaphore.acquire();
   }

   public void addPassenger(Passenger passenger){
        passengers.add(passenger);
   }

    public void addPassengers(Passenger ... addedPassengers){
        passengers.addAll(Arrays.asList(addedPassengers));
    }
}
