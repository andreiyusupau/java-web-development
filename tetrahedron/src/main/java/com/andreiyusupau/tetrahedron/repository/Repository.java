package com.andreiyusupau.tetrahedron.repository;

import com.andreiyusupau.tetrahedron.repository.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {

    void add(T t);

    void remove(T t);

    void update(T t);

    List<T> find(Specification<T> specification);

    List<T> find(Specification<T> specification, Comparator<T> comparator);
}
