package com.andreiyusupau.stringprocessor.service;

public class RegExpSymbolReplacer implements SymbolReplacer{

    public static final String REGEX = "(\\b[a-zA-Z]{2})([a-zA-Z])([a-zA-Z]*\\b)";

@Override
    public String replaceSymbol(String inputString, int k, char symbol) {
       return inputString.replaceAll(REGEX, "$1"+ symbol +"$3");
    }
}
