package com.andreiyusupau.tetrahedron.service.recorder;

public interface Observer<T> {

    void update(T t);

    void setObservable(Observable<T> observable);
}
