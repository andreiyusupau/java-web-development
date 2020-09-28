package com.andreiyusupau.intarray.dao;

import com.andreiyusupau.intarray.model.Array;
import com.andreiyusupau.intarray.util.ArrayConverter;

import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleInputArrayDAO implements DAO<Array> {

    private static final String NUMBER_REGEX="-?\\d{1,9}";

    @Override
    public Array get() {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FilterInputStream(System.in) {
            @Override
            public void close() {
                //Prevent closing System.in
            }
        }))) {
            while (true) {
                System.out.println("Enter the value or type \"exit\":");
                String input = bufferedReader.readLine();
                if (input.matches(NUMBER_REGEX)) {
                    list.add(Integer.valueOf(input));
                } else if (input.toLowerCase().equals("exit")) {
                    return new Array(ArrayConverter.toPrimitive(list));
                } else {
                    System.err.println("Enter an integer number with length less than 10 digits!");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading input.");
        }
        return null;
    }

}
