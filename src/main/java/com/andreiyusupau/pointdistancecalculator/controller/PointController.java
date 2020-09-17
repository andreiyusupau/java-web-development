package com.andreiyusupau.pointdistancecalculator.controller;

import com.andreiyusupau.pointdistancecalculator.service.DistanceCalculator;
import com.andreiyusupau.pointdistancecalculator.view.View;

public class PointController {
    private final DistanceCalculator distanceCalculator;
    private final View view;

    public PointController(DistanceCalculator distanceCalculator, View view) {
        this.distanceCalculator = distanceCalculator;
        this.view = view;
    }

    public void comparePointDistances(){
        String message;
        message= distanceCalculator.getResult();
        view.show(message);
    }
}
