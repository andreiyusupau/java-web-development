package com.andreiyusupau.intarray.view;

import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView implements View {

    @Override
    public void show(String message) {
        System.out.println(message);
    }

    @Override
    public int read(String regex) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FilterInputStream(System.in) {
            @Override
            public void close() {
                //prevent closing System.in
            }
        }))) {
            while (true) {
                String input = bufferedReader.readLine();
                if (input.matches(regex)) {
                    return Integer.parseInt(input);
                } else {
                    System.err.println("Please enter a valid number");
                }
            }
        } catch (IOException e) {
            throw new UserInputReadException("Error reading user input",e);
        }
    }
}
