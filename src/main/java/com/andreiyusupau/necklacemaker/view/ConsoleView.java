package com.andreiyusupau.necklacemaker.view;

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
        System.out.println("1 - Add new gem");
        System.out.println("2 - Get necklace price and weight");
        System.out.println("0 - Exit app");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FilterInputStream(System.in) {
            @Override
            public void close() {
                //prevent closing System.in
            }
        }))) {
            String input = bufferedReader.readLine();
            if (input.matches(regex)) {
                return Integer.parseInt(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
