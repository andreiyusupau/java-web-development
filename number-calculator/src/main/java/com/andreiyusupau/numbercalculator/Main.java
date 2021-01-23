package com.andreiyusupau.numbercalculator;

import com.andreiyusupau.numbercalculator.controller.NumberController;
import com.andreiyusupau.numbercalculator.dao.DAO;
import com.andreiyusupau.numbercalculator.dao.DAOFactory;
import com.andreiyusupau.numbercalculator.service.Calculator;
import com.andreiyusupau.numbercalculator.service.NumberService;
import com.andreiyusupau.numbercalculator.util.PropertiesLoader;
import com.andreiyusupau.numbercalculator.view.View;
import com.andreiyusupau.numbercalculator.view.ViewFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        run(args);
    }

    public static void run(String[] args){
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        ConsoleArgsParser consoleArgsParser = new ConsoleArgsParser(args);
        View view = ViewFactory.getView(propertiesLoader.getProperty("view.type"));
        DAO<Long> numberDAO = DAOFactory.getDAO(propertiesLoader.getProperty("dao.type"));
        Calculator calculator = new Calculator();
        NumberService numberService = new NumberService(calculator, numberDAO);
        NumberController numberController= new NumberController(numberService,view);
        numberController.performOperation(consoleArgsParser.getOperation());
    }

    private static class ConsoleArgsParser {
        private final String operation;
        private final long[] numbers;

        public ConsoleArgsParser(String[] args) {
            operation = args[0];
            numbers = parseNumbers(args);
            writeNumbersToFile();
        }

        private long[] parseNumbers(String[] args) {
            long[] numbers = new long[args.length - 1];
            for (int i = 1; i < args.length; i++) {
                numbers[i - 1] = Long.parseLong(args[i]);
            }
            return numbers;
        }

        public String getOperation() {
            return operation;
        }

        private void writeNumbersToFile() {
            File file = new File("numbers.data");
            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                for (long number : numbers) {
                    bufferedWriter.write(String.valueOf(number));
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                System.err.println("Error writing numbers to file.");
            } finally {
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (IOException e) {
                    System.err.println("Error closing writer.");
                }
            }
        }
    }
}
