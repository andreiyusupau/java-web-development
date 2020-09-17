package com.andreiyusupau.pointdistancecalculator.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;

public class PointReader implements Closeable,AutoCloseable {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public int getCoordinate(String axisName) {
            try {
                while (true) {
                    System.out.println("Enter the value of " + axisName + ":");
                    String input = bufferedReader.readLine();
                    if (input.matches("-?\\d{1,9}")) {
                        return Integer.parseInt(input);
                    } else {
                        System.err.println("Enter an integer number with length less than 10 digits!");
                    }
                }
            }  catch (IOException e) {
                System.err.println("Error reading input.");
            }
            return 0;
    }

    @Override
    public void close(){
        try {
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Error closing reader.");
        }
    }
}
