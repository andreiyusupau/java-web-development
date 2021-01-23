package com.andreiyusupau.textparser.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader implements Reader {

    private static final Logger LOGGER = LogManager.getLogger(FileReader.class);
    @Override
    public String read(String source) {
        LOGGER.info("Reading input from file.");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(source)))) {
            StringBuilder stringBuilder=new StringBuilder();
            String nextLine = bufferedReader.readLine();
            while (nextLine != null) {
                stringBuilder.append(nextLine);
                nextLine = bufferedReader.readLine();
            }
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            throw new DataException("File not found.", e);
        } catch (IOException e) {
            throw new DataException("Error reading file.", e);
        }
    }
}
