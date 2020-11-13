package com.andreiyusupau.textparser.service.parser.interpreter;

import com.andreiyusupau.textparser.service.parser.interpreter.expression.Expression;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;


public class Calculator {

    private static final Logger LOGGER = LogManager.getLogger(Calculator.class);

    public Integer calculate(List<Expression> listExpression) {
        LOGGER.info("Calculating expression.");
        Deque<Integer> context=new ArrayDeque<>();
        listExpression.forEach(terminal-> terminal.interpret(context));
        return context.pop();
    }
}