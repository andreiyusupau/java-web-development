package com.andreiyusupau.tetrahedron.validation;

public class TetrahedronInputValidator implements InputValidator {

    private static final String DECIMAL_REGEX = "-?\\d+(\\.\\d+)?";
    private static final String POINT_REGEX = "\\(" + DECIMAL_REGEX + ",\\s" + DECIMAL_REGEX + ",\\s" +DECIMAL_REGEX+ "\\)";

    @Override
    public boolean isValid(String data) {
        return data.matches("(" + POINT_REGEX + ",\\s){3}" + POINT_REGEX);
    }
}
