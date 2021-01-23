package com.andreiyusupau.textparser.service.parser.interpreter.expression;

import java.util.Deque;

@FunctionalInterface
public interface Expression {
    void interpret(Deque<Integer> context);
}