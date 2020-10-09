package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;

public class PagesMoreThanSpecification extends BasicSpecification<Book> {

    private final int numberOfPages;

    public PagesMoreThanSpecification(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean isSatisfactory(Book book) {
        return book.getNumberOfPages() > numberOfPages;
    }
}
