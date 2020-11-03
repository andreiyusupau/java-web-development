package com.andreiyusupau.busdepot.service;

public interface Observable<T> {

    void addObserver(Observer<T> obj);

    void notifyObservers();

}
