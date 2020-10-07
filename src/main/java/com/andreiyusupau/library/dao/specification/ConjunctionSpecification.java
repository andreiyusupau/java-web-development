package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;

import java.util.List;

public class ConjunctionSpecification implements Specification<Book> {

    private List<Specification<Book>> specifications;

    public ConjunctionSpecification(List<Specification<Book>> specifications) {
        this.specifications = specifications;
    }

    @Override
    public List<Book> specify(List<Book> t) {
        List<Book> result = t;
        for (Specification<Book> specification : specifications) {
            result = specification.specify(result);
        }
        return result;
    }
}
