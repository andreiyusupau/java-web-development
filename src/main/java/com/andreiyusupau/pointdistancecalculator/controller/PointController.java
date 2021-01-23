package com.andreiyusupau.pointdistancecalculator.controller;

import com.andreiyusupau.pointdistancecalculator.service.PointService;
import com.andreiyusupau.pointdistancecalculator.view.View;

public class PointController {

    private final PointService pointService;
    private final View view;

    public PointController(PointService pointService, View view) {
        this.pointService = pointService;
        this.view = view;
    }

    public void comparePointDistances() {
        String message = pointService.getResult();
        view.show(message);
    }
}
