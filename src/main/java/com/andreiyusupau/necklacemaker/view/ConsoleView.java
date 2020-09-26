package com.andreiyusupau.necklacemaker.view;

public class ConsoleView implements View {

    @Override
    public void show(String message) {
        System.out.println(message);
    }
}
