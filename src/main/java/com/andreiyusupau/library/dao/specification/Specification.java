package com.andreiyusupau.library.dao.specification;

import java.util.List;

public interface Specification<T> {

    List<T> specify(List<T> t);
}
