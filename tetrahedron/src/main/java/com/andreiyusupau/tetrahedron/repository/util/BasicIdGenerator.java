package com.andreiyusupau.tetrahedron.repository.util;

public class BasicIdGenerator implements IdGenerator {

    private long currentId = 0;

    @Override
    public long getNextId() {
        increment();
        return currentId;
    }

    private void increment() {
        currentId++;
    }
}
