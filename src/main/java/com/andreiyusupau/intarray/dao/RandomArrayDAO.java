package com.andreiyusupau.intarray.dao;

import com.andreiyusupau.intarray.model.Array;

import java.util.Random;

public class RandomArrayDAO implements DAO<Array> {
    private static final int ARRAY_SIZE=1000;

    @Override
    public Array get() {
        int [] numbers = new int[ARRAY_SIZE];
        Random random=new Random();
        for(int i=0;i<ARRAY_SIZE;i++){
            numbers[i]=random.nextInt();
        }
        return new Array(numbers);
    }
}
