package com.andreiyusupau.numbercalculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void sumShouldReturnSix() {
        Calculator calculator = new Calculator();
        long[] numbers = new long[]{1, 2, 3};
        long sum = calculator.sum(numbers);
        Assertions.assertEquals(6, sum);
    }

    @Test
    void sumShouldReturnZero() {
        Calculator calculator = new Calculator();
        long[] numbers = new long[]{-100, 0, 200, -100};
        long sum = calculator.sum(numbers);
        Assertions.assertEquals(0, sum);
    }

    @Test
    void multiplyShouldReturnZero() {
        Calculator calculator = new Calculator();
        long[] numbers = new long[]{-100, 0, 2000, 105};
        long mul = calculator.multiply(numbers);
        Assertions.assertEquals(0, mul);
    }

    @Test
    void multiplyShouldReturnMinusTen() {
        Calculator calculator = new Calculator();
        long[] numbers = new long[]{-2, 5, -1, 1, -1};
        long mul = calculator.multiply(numbers);
        Assertions.assertEquals(-10, mul);
    }

}
