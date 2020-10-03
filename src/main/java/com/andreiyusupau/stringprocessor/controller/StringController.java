package com.andreiyusupau.stringprocessor.controller;

import com.andreiyusupau.stringprocessor.service.StringProcessingService;
import com.andreiyusupau.stringprocessor.view.View;

public class StringController {

private final StringProcessingService stringProcessingService;
private final View view;

    public StringController(StringProcessingService stringProcessingService, View view) {
    this.stringProcessingService=stringProcessingService;
    this.view=view;
    }

    public void process() {
   String processedString=stringProcessingService.process();
   view.show("The result is:");
        view.show(processedString);
    }
}
