package com.andreiyusupau.numbercalculator.service;

import com.andreiyusupau.numbercalculator.dao.DAO;

import java.util.List;

public class NumberService {

    private final Calculator calculator;
    private final DAO<Long> numberDAO;

    public NumberService(Calculator calculator, DAO<Long> numberDAO) {
        this.calculator = calculator;
        this.numberDAO = numberDAO;
    }

    public long process(String operationType) {
        long[] numbers = toPrimitiveArray(numberDAO.getAll());
        return performOperation(operationType, numbers);
    }

    private long[] toPrimitiveArray(List<Long> inputList) {
        long[] outputArray = new long[inputList.size()];
        for (int i = 0; i < inputList.size(); i++) {
            outputArray[i] = inputList.get(i);
        }
        return outputArray;
    }

    private long performOperation(String operationType, long[] numbers) {
        switch (operationType) {
            case "sum":
                return calculator.sum(numbers);
            case "multiply":
                return calculator.multiply(numbers);
            default:
                throw new NoSuchArithmeticOperationException("Unknown arithmetic operation -\"" + operationType + "\"");
        }
    }

    private static class NoSuchArithmeticOperationException extends RuntimeException {

        public NoSuchArithmeticOperationException(String errorMessage) {
            super(errorMessage);
        }
    }
}
