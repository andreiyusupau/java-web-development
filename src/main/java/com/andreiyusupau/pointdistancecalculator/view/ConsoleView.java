package com.andreiyusupau.pointdistancecalculator.view;

public class ConsoleView implements View {

    @Override
    public void show(String message) {
        System.out.println(message);
    }
}
