package com.andreiyusupau.intarray.dao;

import com.andreiyusupau.intarray.model.Array;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomArrayDAOTest {

    @Test
    void testGetShouldReturnArrayWithLengthMoreThanZero() {
        DAO<Array> arrayDAO = new RandomArrayDAO();
        Array array = arrayDAO.get();
        int arrayLength = array.length();
        Assertions.assertTrue(arrayLength > 0);
    }

    @Test
    void testGetShouldNotReturnNull() {
        DAO<Array> arrayDAO = new RandomArrayDAO();
        Array array = arrayDAO.get();
        Assertions.assertNotEquals(null, array);
    }
}
