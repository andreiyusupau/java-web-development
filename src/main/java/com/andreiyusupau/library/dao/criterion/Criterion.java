package com.andreiyusupau.library.dao.criterion;

import java.util.List;

public interface Criterion<T> {

    List<T> filter(List<T> t);
}
