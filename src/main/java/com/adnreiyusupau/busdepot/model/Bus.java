package com.adnreiyusupau.busdepot.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public final class Bus implements Runnable {

    private final Route route;
    private final Set<Passenger> passengers=new HashSet<>();
    private final ReentrantLock lock=new ReentrantLock();
    private Iterator<BusStop> busStopIterator;
   private BusStop currentBusStop=null;

    public Bus(Route route) {
        this.route = route;
        busStopIterator=route.getIterator();
    }

    public void run() {
        while (true) {
            if (busStopIterator.hasNext()) {
            lock.lock();
            try {

                    if (currentBusStop != null) {
                        currentBusStop.leave();
                    }
                    currentBusStop = busStopIterator.next();
                    currentBusStop.arrive();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            } else {
                break;
            }

        }

//getNextStop
        //ride
        //trysemaphore stop
        //unlock open doors
        //wait
        //trylock
        //opensemaphore stop
        //getNextStop
        //--->
    }

    public void enter(Passenger passenger){
        lock.tryLock();
        try {
            passengers.add(passenger);
        }finally {
            lock.unlock();
        }
    }

    public void exit(Passenger passenger){
        lock.lock();
        try {
            passengers.remove(passenger);
        }finally {
            lock.unlock();
        }
    }
}
