package com.andreiyusupau.necklacemaker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DAOFactoryTest {

    @Test
    void testGetDAOShouldThrowException(){
        Assertions.assertThrows(NoSuchDAOImplementationException.class,()->DAOFactory.getDAO("Definitely non existent DAO"));
    }
}
