package com.andreiyusupau.library.dao;

import com.andreiyusupau.library.dao.specification.Specification;

import java.util.List;

public interface Dao<T> {

    long add(T t);

    boolean remove(long id);

    List<T> find(Specification<T> specification);
}
