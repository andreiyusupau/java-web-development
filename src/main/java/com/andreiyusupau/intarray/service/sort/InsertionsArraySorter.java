package com.andreiyusupau.intarray.service.sort;

import com.andreiyusupau.intarray.model.Array;

public class InsertionsArraySorter implements ArraySorter {

    @Override
    public Array sort(Array array) {
        return new Array(sort(array.getNumbers()));
    }

    private int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > value) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = value;
        }
        return array;
    }
}
