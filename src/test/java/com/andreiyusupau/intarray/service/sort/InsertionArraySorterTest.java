package com.andreiyusupau.intarray.service.sort;

import com.andreiyusupau.intarray.model.Array;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertionArraySorterTest {

    @Test
    void testSortShouldReturnSortedArray() {
        //given
        ArraySorter arraySorter = new InsertionsArraySorter();
        int[] numbers = new int[]{28, -13, 85, 33, 9, -2, -12, 0, 58, 95};
        Array array = new Array(numbers);
        //when
        array = arraySorter.sort(array);
        //then
        Array expected = new Array(new int[]{-13, -12, -2, 0, 9, 28, 33, 58, 85, 95});
        Assertions.assertEquals(expected, array);
    }
}
