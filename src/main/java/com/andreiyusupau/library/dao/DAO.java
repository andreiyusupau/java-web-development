package com.andreiyusupau.library.dao;

import com.andreiyusupau.library.dao.criterion.Criterion;

import java.util.List;

public interface DAO<T> {

    long add(T t);

    boolean remove(long id);

    List<T> find(Criterion<T> criterion);
}
