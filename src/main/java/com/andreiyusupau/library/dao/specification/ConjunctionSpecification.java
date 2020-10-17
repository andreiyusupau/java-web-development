package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;

import java.util.List;

public class ConjunctionSpecification implements Specification<Book> {

    private final List<Specification<Book>> specifications;

    public ConjunctionSpecification(List<Specification<Book>> specifications) {
        this.specifications = specifications;
    }

    @Override
    public boolean specified(Book book) {
        for (Specification<Book> specification : specifications) {
            if(!specification.specified(book)){
                return false;
            }
        }
        return true;
    }
}
