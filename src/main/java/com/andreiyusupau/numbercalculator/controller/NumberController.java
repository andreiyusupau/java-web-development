package com.andreiyusupau.numbercalculator.controller;

import com.andreiyusupau.numbercalculator.service.NumberService;
import com.andreiyusupau.numbercalculator.view.View;

public class NumberController {

    private final NumberService numberService;
    private final View view;

    public NumberController(NumberService numberService, View view) {
        this.numberService = numberService;
        this.view = view;
    }

    public void performOperation(String operation) {
        long operationResult= numberService.process(operation);
        String message = "The result of the "+operation+" operation is "+operationResult;
        view.show(message);
    }
}
