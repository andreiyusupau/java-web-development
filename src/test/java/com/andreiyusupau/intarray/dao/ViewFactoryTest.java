package com.andreiyusupau.intarray.dao;

import com.andreiyusupau.intarray.view.NoSuchViewImplementationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ViewFactoryTest {

    @Test
    void shouldThrowException(){
        Assertions.assertThrows(NoSuchDAOImplementationException.class,()-> DAOFactory.getDAO("Definitely non existent DAO"));
    }
}
