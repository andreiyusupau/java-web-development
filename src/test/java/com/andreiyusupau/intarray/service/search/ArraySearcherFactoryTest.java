package com.andreiyusupau.intarray.service.search;

import com.andreiyusupau.intarray.service.sort.NoSuchArraySorterImplementationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArraySearcherFactoryTest {

    @Test
    void testGetArraySearcherShouldThrowException(){
        Assertions.assertThrows(NoSuchArraySorterImplementationException.class,()-> ArraySearcherFactory.getArraySearcher("Definitely non existent arraySearcher"));
    }
}
