package com.andreiyusupau.pointdistancecalculator.dao;

import com.andreiyusupau.pointdistancecalculator.model.Point;

import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputPointDAO implements DAO<Point> {
    private final PointReader pointReader = new PointReader();

    public ConsoleInputPointDAO() {
    }

    @Override
    public Point get() {
        int x = pointReader.getCoordinate("x");
        int y = pointReader.getCoordinate("y");
        return new Point(x, y);
    }

    private static class PointReader {

        public int getCoordinate(String axisName) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FilterInputStream(System.in){
                @Override
                public void close(){
                    //Prevent closing System.in
                }
            }));
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
            } catch (IOException e) {
                System.err.println("Error reading input.");
            }finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.err.println("Error closing reader.");
                }
            }
            return 0;
        }
    }
}
