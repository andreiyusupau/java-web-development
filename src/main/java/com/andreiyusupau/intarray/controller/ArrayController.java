package com.andreiyusupau.intarray.controller;

import com.andreiyusupau.intarray.service.ArrayService;
import com.andreiyusupau.intarray.view.View;

public class ArrayController {

    private final ArrayService arrayService;
    private final View view;

    public ArrayController(ArrayService arrayService, View view) {
        this.arrayService = arrayService;
        this.view = view;
    }

    public void init() {
        view.show("Welcome to array manipulation service.");
        process();
    }

    private void process() {
        boolean exit = false;
        while (!exit) {
            view.show("1 - Create new array.");
            view.show("2 - Sort array.");
            view.show("3 - Find index of number in array.");
            view.show("0 - Exit.");
            final String MENU_INPUT_REGEX = "[0-3]";
            int input = view.read(MENU_INPUT_REGEX);
            switch (input) {
                case 1:
                    arrayService.createArray();
                    view.show("Array created.");
                    break;
                case 2:
                    arrayService.sort();
                    view.show("Array sorted.");
                    break;
                case 3: {
                    view.show("Enter number to search for:");
                    final String NUMBER_INPUT_REGEX = "-?\\d{1,9}";
                    int numberToSearch = view.read(NUMBER_INPUT_REGEX);
                    int position = arrayService.search(numberToSearch);
                    if (position != -1) {
                        view.show("Number " + numberToSearch + " is on the position " + position + " in the array.");
                    } else {
                        view.show("Number " + numberToSearch + " is not in the array.");
                    }
                }
                case 0:
                    exit = true;
                    break;
            }
        }
    }
}
