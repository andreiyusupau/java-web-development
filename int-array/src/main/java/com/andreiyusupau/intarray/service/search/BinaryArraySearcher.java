package com.andreiyusupau.intarray.service.search;

import com.andreiyusupau.intarray.model.Array;

public class BinaryArraySearcher implements ArraySearcher {

    @Override
    public int search(Array array, int value) {
        if (array.length() < 1) {
            return -1;
        }
        int low = 0;
        int high = array.length() - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array.get(mid) < value) {
                low = mid + 1;
            } else if (array.get(mid) > value) {
                high = mid - 1;
            } else if (array.get(mid) == value) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
