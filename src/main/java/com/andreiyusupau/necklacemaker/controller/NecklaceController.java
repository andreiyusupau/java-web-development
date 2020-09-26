package com.andreiyusupau.necklacemaker.controller;


import com.andreiyusupau.necklacemaker.service.NecklaceService;
import com.andreiyusupau.necklacemaker.view.View;

public class NecklaceController {

    private final NecklaceService necklaceService;
    private final View view;

    public NecklaceController(NecklaceService necklaceService, View view) {
        this.necklaceService = necklaceService;
        this.view = view;
    }
}
