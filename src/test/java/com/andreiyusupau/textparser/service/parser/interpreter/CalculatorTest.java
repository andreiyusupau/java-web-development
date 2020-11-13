package com.andreiyusupau.textparser.service.parser.interpreter;


import com.andreiyusupau.textparser.service.parser.interpreter.expression.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private final Calculator calculator = new Calculator();
    private final Expression plus = context -> context.push(context.pop() + context.pop());
    private final Expression two = context -> context.push(2);
    private List<Expression> expressions;

    @BeforeEach
    void set() {
        expressions = List.of(two, two, plus);
    }

    @Test
    void calculateShouldReturnFour() {
        int result = calculator.calculate(expressions);
        assertEquals(4, result);
    }

    @Test
    void calculateShouldThrowNoSuchElementException() {
        //TODO:
        int result = calculator.calculate(expressions);
        assertEquals(4, result);
    }
}
