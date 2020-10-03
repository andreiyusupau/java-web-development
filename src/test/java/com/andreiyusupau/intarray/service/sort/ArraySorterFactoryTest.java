package com.andreiyusupau.intarray.service.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArraySorterFactoryTest {

    @Test
    void testGetArraySorterShouldThrowException(){
        Assertions.assertThrows(NoSuchArraySorterImplementationException.class,()-> ArraySorterFactory.getArraySorter("Definitely non existent arraySorter"));
    }
}
