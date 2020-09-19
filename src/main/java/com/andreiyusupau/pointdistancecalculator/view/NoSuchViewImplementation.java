package com.andreiyusupau.pointdistancecalculator.view;

public class NoSuchViewImplementation extends RuntimeException{

    public NoSuchViewImplementation(String errorMessage){
        super(errorMessage);
    }
}
