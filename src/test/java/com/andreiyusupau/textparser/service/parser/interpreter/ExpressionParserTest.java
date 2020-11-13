package com.andreiyusupau.textparser.service.parser.interpreter;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Leaf;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExpressionParserTest {

    private final String expression="2 2 +";
    @Mock
    private Calculator calculator;
    @InjectMocks
    private ExpressionParser expressionParser;

    @Test
    void shouldReturnFour(){
        when(calculator.calculate(any())).thenReturn(4);
        Component component =expressionParser.parse(expression);
        int result=Integer.parseInt(((Leaf)component).getValue());
        assertEquals(4,result);
    }
}
