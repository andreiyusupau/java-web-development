package com.andreiyusupau.busdepot;

import com.andreiyusupau.busdepot.model.Bus;
import com.andreiyusupau.busdepot.model.BusStop;
import com.andreiyusupau.busdepot.model.Passenger;
import com.andreiyusupau.busdepot.model.Route;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        BusStop busStopA=new BusStop("A", new Semaphore(1));
        BusStop busStopB=new BusStop("B", new Semaphore(1));
        Passenger passengerX=new Passenger(busStopB);
        Passenger passengerY=new Passenger(busStopB);
        Passenger passengerZ=new Passenger(busStopB);
        busStopA.addPassengers(passengerX,passengerY,passengerZ);
        Route route=new Route();
        route.addStops(busStopA,busStopB);
        ExecutorService passengerService=Executors.newFixedThreadPool(3);
        passengerService.execute(passengerX);
        passengerService.execute(passengerY);
        passengerService.execute(passengerZ);
        ExecutorService busService=Executors.newFixedThreadPool(1);
        Bus bus=new Bus(route);
        busService.execute(bus);

        shutdown(busService);

    }

    public static void shutdown(ExecutorService executorService){
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
