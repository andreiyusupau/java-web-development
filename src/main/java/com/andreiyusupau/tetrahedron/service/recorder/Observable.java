package com.andreiyusupau.tetrahedron.service.recorder;

public interface Observable<T> {

    void addObserver(Observer<T> obj);

    void notifyObservers();

}
