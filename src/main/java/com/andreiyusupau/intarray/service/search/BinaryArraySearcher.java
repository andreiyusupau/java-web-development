package com.andreiyusupau.intarray.service.search;

import com.andreiyusupau.intarray.model.Array;

public class BinaryArraySearcher implements ArraySearcher {

    @Override
    public int search(Array array, int value) {
        return binarySearch(array.getNumbers(), value);
    }

    private int binarySearch(int[] sortedArray, int value) {
        int low = 0;
        int high = sortedArray.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < value) {
                low = mid + 1;
            } else if (sortedArray[mid] > value) {
                high = mid - 1;
            } else if (sortedArray[mid] == value) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
