package com.andreiyusupau.tetrahedron.repository.specification;

public interface Specification<T> {
    boolean specified(T t);
}
