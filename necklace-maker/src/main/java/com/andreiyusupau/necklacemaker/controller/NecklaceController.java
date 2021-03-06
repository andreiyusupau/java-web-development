package com.andreiyusupau.necklacemaker.controller;


import com.andreiyusupau.necklacemaker.service.NecklaceService;
import com.andreiyusupau.necklacemaker.view.View;

import java.math.BigDecimal;

public class NecklaceController {

    private final NecklaceService necklaceService;
    private final View view;
    private static final String MENU_REGEX="[0-2]";

    public NecklaceController(NecklaceService necklaceService, View view) {
        this.necklaceService = necklaceService;
        this.view = view;
    }

    public void init() {
        view.show("WELCOME TO THE NECKLACE CREATOR 1.0");
        view.show("Lets create a new necklace");
        process();
    }

    private void process() {
        boolean exit = false;
        while (!exit) {
            int input = view.read(MENU_REGEX);
            switch (input) {
                case 1:
                    necklaceService.addGem();
                    break;
                case 2: {
                    necklaceService.createNecklace();
                    double mass = necklaceService.getNecklaceMass();
                    BigDecimal price = necklaceService.getNecklacePrice();
                    view.show("Necklace created. Its weight is " + mass + " carats at price of " + price + " $.");
                    exit = true;
                    break;
                }
                case 0:
                    exit = true;
                    break;
            }
        }
    }
}
