package com.andreiyusupau.numbercalculator.dao;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileNumberDAO implements DAO<Long> {

    @Override
    public List<Long> getAll() {
        List<Long> numbersList = new ArrayList<>();
        File file = new File("numbers.data");
        if (file.exists() && file.length() != 0) {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String nextLine;
                while ((nextLine = bufferedReader.readLine()) != null) {
                    numbersList.add(Long.valueOf(nextLine));
                }
            } catch (FileNotFoundException e) {
                System.err.println("File with numbers not found.");
            } catch (IOException e) {
                System.err.println("Error reading file with numbers.");
            } finally {
                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (IOException e) {
                    System.err.println("Error closing file reader.");
                }
            }
        }
        return numbersList;
    }

}
