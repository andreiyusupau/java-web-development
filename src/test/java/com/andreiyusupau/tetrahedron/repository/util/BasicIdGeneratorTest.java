package com.andreiyusupau.tetrahedron.repository.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicIdGeneratorTest {

    private IdGenerator idGenerator;

    @BeforeEach
    void init() {
        idGenerator = new BasicIdGenerator();
    }

    @Test
    void getNextIdShouldReturnOneOnFirstLaunch() {
        long id = idGenerator.getNextId();

        long expected = 1;
        assertEquals(expected, id);
    }

    @Test
    void getNextIdShouldReturnOneTwoThree() {
        long[] idList = new long[3];

        idList[0] = idGenerator.getNextId();
        idList[1] = idGenerator.getNextId();
        idList[2] = idGenerator.getNextId();

        long[] expected = new long[]{1, 2, 3};
        assertArrayEquals(expected, idList);
    }
}
