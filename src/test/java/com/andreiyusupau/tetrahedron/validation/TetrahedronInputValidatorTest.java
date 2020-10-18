package com.andreiyusupau.tetrahedron.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TetrahedronInputValidatorTest {

    private final TetrahedronInputValidator tetrahedronInputValidator=new TetrahedronInputValidator();

    @Test
    void isValidShouldReturnFalseWhenInputIncludesIllegalSymbols(){
        String input="(0.0, 0.5z, 0.3), (2.6, 5.4, -2.4), (4.5, 3.6, -6.8), (5.6, 1.7, 5.9)";
        boolean stringIsValid=tetrahedronInputValidator.isValid(input);
        assertFalse(stringIsValid);
    }

    @Test
    void isValidShouldReturnFalseWhenOnePointIsMissing(){
        String input="(2.6, 5.4, -2.4), (4.5, 3.6, -6.8), (5.6, 1.7, 5.9)";
        boolean stringIsValid=tetrahedronInputValidator.isValid(input);
        assertFalse(stringIsValid);
    }

    @Test
    void isValidShouldReturnTrue(){
        String input="(0.0, 0.5, 0.3), (2.6, 5.4, -2.4), (4.5, 3.6, -6.8), (5.6, 1.7, 5.9)";
        boolean stringIsValid=tetrahedronInputValidator.isValid(input);
        assertTrue(stringIsValid);
    }
}
