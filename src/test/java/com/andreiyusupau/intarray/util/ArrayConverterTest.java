package com.andreiyusupau.intarray.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayConverterTest {

    @Test
    void testToPrimitiveShouldReturnPrimitiveArray(){
        //given
        int [] givenArray= new int[]{1,2,3,4,5,-29};
        List<Integer> integerList= new ArrayList<>();
        for(int number:givenArray){
            integerList.add(number);
        }
        //when
        int [] resultArray= ArrayConverter.toPrimitive(integerList);
        //then
        Assertions.assertArrayEquals(givenArray,resultArray);
    }
}
