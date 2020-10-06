package com.andreiyusupau.stringprocessor.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ViewFactoryTest {

    @Test
    void testGetViewShouldThrowException(){
        Assertions.assertThrows(NoSuchViewImplementationException.class,()-> ViewFactory.getView("Definitely non existent view"));
    }
}
