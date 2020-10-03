package com.andreiyusupau.intarray.service;

import com.andreiyusupau.intarray.dao.DAO;
import com.andreiyusupau.intarray.model.Array;
import com.andreiyusupau.intarray.service.search.ArraySearcher;
import com.andreiyusupau.intarray.service.sort.ArraySorter;

public class ArrayService {

    private final ArraySorter arraySorter;
    private final ArraySearcher arraySearcher;
    private final DAO<Array> arrayDAO;
    private Array array;

    public ArrayService(ArraySorter arraySorter, ArraySearcher arraySearcher, DAO<Array> arrayDAO) {
        this.arraySorter = arraySorter;
        this.arraySearcher = arraySearcher;
        this.arrayDAO = arrayDAO;
    }

    public void createArray() {
        array = arrayDAO.get();
    }

    public void sort() {
        if (array != null) {
            arraySorter.sort(array);
        } else {
            System.err.println("Array is null. First create an array.");
        }
    }

    public int search(int value) {
        if (array != null) {
            return arraySearcher.search(array, value);
        } else {
            System.err.println("Array is null. First create an array.");
            return -1;
        }
    }
}
