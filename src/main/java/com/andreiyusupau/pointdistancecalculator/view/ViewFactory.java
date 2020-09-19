package com.andreiyusupau.pointdistancecalculator.view;

public class ViewFactory {

    public static View getView(String type){
        switch (type.toLowerCase()){
            case "console":
                return new ConsoleView();
            default:
                throw new NoSuchViewImplementation("View referred to type \""+type+"\" does not exists.");
        }
    }

}
