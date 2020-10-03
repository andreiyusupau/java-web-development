package com.andreiyusupau.intarray.util;

import java.util.List;

public class ArrayConverter {

    public static int[] toPrimitive(List<Integer> list) {
        if (list != null && list.size() > 0) {
            int[] array = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                array[i] = list.get(i);
            }
            return array;
        } else {
            throw new EmptyListException("List is empty or is null.");
        }
    }

}
