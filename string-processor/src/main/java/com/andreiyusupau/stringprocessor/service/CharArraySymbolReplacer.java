package com.andreiyusupau.stringprocessor.service;

public class CharArraySymbolReplacer implements SymbolReplacer {

    @Override
    public String replaceSymbol(String inputString, int k, char symbol) {
        int counter = 0;
        char[] chars = inputString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            counter++;
            if (chars[i] == ' ') {
                counter = 0;
            } else if (k == counter) {
                chars[i] = symbol;
            }
        }
        return new String(chars);
    }
}
