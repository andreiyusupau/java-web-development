package com.andreiyusupau.textparser.service.parser.interpreter;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Leaf;
import com.andreiyusupau.textparser.service.parser.Parser;
import com.andreiyusupau.textparser.service.parser.interpreter.expression.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionParser implements Parser<Component,String> {

    private final Calculator calculator;

    public ExpressionParser(Calculator calculator) {
        this.calculator = calculator;
    }

    public Component parse(String expression) {
        List<Expression> listExpression=new ArrayList<>();
        for (String lexeme : expression.split("\\p{Blank}+")) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    listExpression.add(context-> context.push(context.pop() + context.pop()));
                    break;
                case '-':
                    listExpression.add(context->context.push(context.pop() - context.pop()));
                    break;
                case '*':
                    listExpression.add( context->context.push(context.pop() * context.pop()));
                    break;
                case '/':
                    listExpression.add(context->context.push(context.pop() / context.pop()));
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()) {
                        listExpression.add(context->context.push(scan.nextInt()));
                    }
            }
        }
        int calculationResult=calculator.calculate(listExpression);
        String expressionResult=String.valueOf(calculationResult);
        return Leaf.newExpression(expressionResult);
    }
}
