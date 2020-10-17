package com.andreiyusupau.library.dao.specification;

public interface Specification<T> {

    boolean specified(T t);
}
