package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;

public class PagesMoreThanSpecification implements Specification<Book> {

    private final int numberOfPages;

    public PagesMoreThanSpecification(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean specified(Book book) {
        return book.getNumberOfPages() > numberOfPages;
    }
}
