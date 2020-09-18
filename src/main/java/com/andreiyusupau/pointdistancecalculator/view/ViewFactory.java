package com.andreiyusupau.pointdistancecalculator.view;

public class ViewFactory {

    private static ViewFactory instance;

    private ViewFactory(){

    }

    public ConsoleView getConsoleView(){
        return new ConsoleView();
    }

    public static ViewFactory getInstance() {
        if (instance == null) {
            instance = new ViewFactory();
        }
        return instance;
    }
}
