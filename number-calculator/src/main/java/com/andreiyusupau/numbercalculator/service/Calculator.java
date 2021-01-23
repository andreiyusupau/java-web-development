package com.andreiyusupau.numbercalculator.service;

public class Calculator {

    public long sum(long[] numbers) {
        return sum(numbers, 0);
    }

    public long sum(long[] numbers, int index) {
        return index == numbers.length - 1 ? numbers[index] : numbers[index] + sum(numbers, index + 1);
    }

    public long multiply(long[] numbers) {
        return multiply(numbers, 0);
    }

    public long multiply(long[] numbers, int index) {
        return index == numbers.length - 1 ? numbers[index] : numbers[index] * multiply(numbers, index + 1);
    }
}
