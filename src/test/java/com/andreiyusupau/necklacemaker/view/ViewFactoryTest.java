package com.andreiyusupau.necklacemaker.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ViewFactoryTest {

    @Test
    void shouldThrowException(){
        Assertions.assertThrows(NoSuchViewImplementationException.class,()-> ViewFactory.getView("Definitely non existent view"));
    }
}
