package com.andreiyusupau.busdepot.service;

import com.andreiyusupau.busdepot.model.Bus;
import com.andreiyusupau.busdepot.model.BusStop;
import com.andreiyusupau.busdepot.model.Passenger;
import com.andreiyusupau.busdepot.model.Route;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class BusDepotTest {

    @Test
    void checkBusDepotShouldNotThrowExceptions(){
        BusStop busStopA=new BusStop("A", new Semaphore(1));
        BusStop busStopB=new BusStop("B", new Semaphore(1));
        BusStop busStopC=new BusStop("C", new Semaphore(1));
        Passenger passengerAB=new Passenger(busStopB);
        Passenger passengerAC=new Passenger(busStopC);
        Passenger passengerBC=new Passenger(busStopC);
        Passenger passengerBA=new Passenger(busStopA);
        Passenger passengerCA=new Passenger(busStopA);
        Passenger passengerCB=new Passenger(busStopB);
        busStopA.addPassengers(passengerAB,passengerAC);
        busStopB.addPassengers(passengerBC,passengerBA);
        busStopC.addPassengers(passengerCA,passengerCB);
        Route routeAB=new Route();
        Route routeBC=new Route();
        Route routeCA=new Route();
        routeAB.addStops(busStopA,busStopB);
        routeBC.addStops(busStopB,busStopC);
        routeCA.addStops(busStopC,busStopA);
        ExecutorService passengerService= Executors.newFixedThreadPool(6);
        passengerService.execute(passengerAB);
        passengerService.execute(passengerAC);
        passengerService.execute(passengerBC);
        passengerService.execute(passengerBA);
        passengerService.execute(passengerCA);
        passengerService.execute(passengerCB);
        Bus busAB=new Bus(routeAB);
        Bus busBC=new Bus(routeBC);
        Bus busCA=new Bus(routeCA);
        BusDepot busDepot=BusDepot.getInstance();
        busDepot.addBus(busAB);
        busDepot.addBus(busBC);
        busDepot.addBus(busCA);
        busDepot.start();
        busDepot.finish(5);
        shutdown(passengerService);
    }

    public void shutdown(ExecutorService executorService){
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(50000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
