package com.andreiyusupau.busdepot.service;

public interface Observer<T> {

    void update(T t);

}
