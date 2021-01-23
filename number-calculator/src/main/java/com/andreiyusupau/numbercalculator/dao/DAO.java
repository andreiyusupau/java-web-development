package com.andreiyusupau.numbercalculator.dao;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
}
