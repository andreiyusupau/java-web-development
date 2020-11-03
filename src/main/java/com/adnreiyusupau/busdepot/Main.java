package com.adnreiyusupau.busdepot;

import com.adnreiyusupau.busdepot.model.BusStop;
import com.adnreiyusupau.busdepot.model.Passenger;
import com.adnreiyusupau.busdepot.model.Route;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        BusStop busStopA=new BusStop("A", new Semaphore(1));
        BusStop busStopB=new BusStop("B", new Semaphore(1));
        Passenger passengerX=new Passenger();
        Passenger passengerY=new Passenger();
        Passenger passengerZ=new Passenger();
        busStopA.addPassengers(passengerX,passengerY,passengerZ);
        Route route=new Route();
        route.addStops(busStopA,busStopB);
        ExecutorService passengerService=Executors.newFixedThreadPool(3);
        ExecutorService busService=Executors.newFixedThreadPool(1);
        passengerService.execute(passengerX);
        passengerService.execute(passengerY);
        passengerService.execute(passengerZ);
    }
}
