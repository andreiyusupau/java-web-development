package com.andreiyusupau.library.dao.specification;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicSpecification<T> implements Specification<T> {

    @Override
    public List<T> specify(List<T> list){
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (isSatisfactory(element)) {
               result.add(element);
            }
        }
        return result;
    }

    abstract public boolean isSatisfactory(T element);
}
