package com.andreiyusupau.tetrahedron.data;

import java.util.Collection;

public interface DataReader<T> {
    Collection<T> getAll();
}
