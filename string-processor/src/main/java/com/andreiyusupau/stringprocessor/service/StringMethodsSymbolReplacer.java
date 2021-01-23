package com.andreiyusupau.stringprocessor.service;

public class StringMethodsSymbolReplacer implements SymbolReplacer {

    @Override
    public String replaceSymbol(String inputString, int k, char symbol) {
        String[] words = inputString.split("\\s");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < k) {
                stringBuilder.append(words[i]);
            } else {
                stringBuilder.append(words[i], 0, k - 1).append(symbol).append(words[i].substring(k));
            }
            if (i != words.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
