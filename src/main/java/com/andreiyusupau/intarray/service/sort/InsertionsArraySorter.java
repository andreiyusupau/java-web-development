package com.andreiyusupau.intarray.service.sort;

import com.andreiyusupau.intarray.model.Array;

public class InsertionsArraySorter implements ArraySorter {

    @Override
    public Array sort(Array array) {
        for (int i = 1; i < array.length(); i++) {
            int value = array.get(i);
            int j = i;
            while (j > 0 && array.get(j - 1) > value) {
                int temp = array.get(j - 1);
                array.set(j, temp);
                j--;
            }
            array.set(j, value);
        }
        return array;
    }
}
