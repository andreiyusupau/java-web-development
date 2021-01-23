package com.andreiyusupau.stringprocessor.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegExpSymbolReplacerTest {

    @Test
    void testReplaceSymbolShouldReturnStringWithReplacedSymbols() {
        //given
        String input = "String where symbols would be replaced";
        char symbolToReplaceWith = 'X';
        int symbolPosition = 6;
        SymbolReplacer symbolReplacer = new RegExpSymbolReplacer();
        //when
        String resultString = symbolReplacer.replaceSymbol(input, symbolPosition, symbolToReplaceWith);
        //then
        String expectedString = "StrinX where symboXs would be replaXed";
        Assertions.assertEquals(expectedString, resultString);
    }
}
