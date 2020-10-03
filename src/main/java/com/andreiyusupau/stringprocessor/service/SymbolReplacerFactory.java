package com.andreiyusupau.stringprocessor.service;

public class SymbolReplacerFactory {

    public static SymbolReplacer getSymbolReplacer(String type){
        switch (type.toLowerCase()){
            case "char":
                return new CharArraySymbolReplacer();
            case "string":
                return new StringMethodsSymbolReplacer();
            case "regex":
                return new RegExpSymbolReplacer();
            default:
                throw new NoSuchSymbolReplacerImplementationException("SymbolReplacer referred to type \""+type+"\" does not exists.");
        }
    }
}
