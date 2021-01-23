package com.andreiyusupau.tetrahedron.data.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TetrahedronInputValidator implements InputValidator {

    private static final String DECIMAL_REGEX = "-?\\d+(\\.\\d+)?";
    private static final String POINT_REGEX = "\\(" + DECIMAL_REGEX + ",\\s" + DECIMAL_REGEX + ",\\s" + DECIMAL_REGEX + "\\)";
    private static final String TETRAHEDRON_REGEX = "(" + POINT_REGEX + ",\\s){3}" + POINT_REGEX;
    private final Pattern pattern;

    public TetrahedronInputValidator() {
        pattern = Pattern.compile(TETRAHEDRON_REGEX);
    }

    @Override
    public boolean isValid(String data) {
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
}
