package com.andreiyusupau.numbercalculator;

import com.andreiyusupau.numbercalculator.service.Calculator;
import com.andreiyusupau.numbercalculator.util.PropertiesLoader;
import com.andreiyusupau.numbercalculator.view.View;
import com.andreiyusupau.numbercalculator.view.ViewFactory;

public class Main {

    public static void main(String[] args) {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        View view = ViewFactory.getView(propertiesLoader.getProperty("view.type"));
        Calculator calculator = new Calculator();


        long[] numbers = new long[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            numbers[i - 1] = Long.parseLong(args[i]);
        }

        long calcResult=0;
        switch (args[0]) {
            case "sum":
                calcResult = calculator.sum(numbers);
                break;
            case "mul":
                calcResult = calculator.multiply(numbers);
                break;
            default:
               //TODO:
        }
                view.show(" "+calcResult);
    }
}
