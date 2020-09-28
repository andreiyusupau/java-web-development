package com.andreiyusupau.intarray.service.search;

import com.andreiyusupau.intarray.model.Array;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryArraySearcherTest {

    @Test
    void shouldReturnMinusOne() {
        //given
        ArraySearcher arraySearcher = new BinaryArraySearcher();
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 27, 28, 29, 30};
        Array array = new Array(numbers);
        //when
        int searchResult = arraySearcher.search(array, 26);
        //then
        Assertions.assertEquals(-1, searchResult);
    }

    @Test
    void shouldReturnSix() {
        //given
        ArraySearcher arraySearcher = new BinaryArraySearcher();
        int[] numbers = new int[]{-1, 0, 2, 14, 35, 36, 47, 58, 61, 100};
        Array array = new Array(numbers);
        //when
        int searchResult = arraySearcher.search(array, 47);
        //then
        Assertions.assertEquals(6, searchResult);
    }

}
