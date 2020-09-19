package com.andreiyusupau.pointdistancecalculator.dao;

public class NoSuchDAOImplementation extends RuntimeException {

    public NoSuchDAOImplementation(String errorMessage){
        super(errorMessage);
    }
}
