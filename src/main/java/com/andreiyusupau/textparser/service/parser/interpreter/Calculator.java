package com.andreiyusupau.textparser.service.parser.interpreter;

import com.andreiyusupau.textparser.service.parser.interpreter.expression.Expression;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Calculator {

    public Integer calculate(List<Expression> listExpression) {
        Deque<Integer> context=new ArrayDeque<>();
        listExpression.forEach(terminal-> terminal.interpret(context));
        return context.pop();
    }
}