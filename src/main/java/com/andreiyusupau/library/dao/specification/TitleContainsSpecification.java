package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;

public class TitleContainsSpecification extends BasicSpecification<Book> {

    private final String title;

    public TitleContainsSpecification(String title) {
        this.title = title;
    }

    @Override
    public boolean isSatisfactory(Book book) {
        return book.getTitle().contains(title);
    }
}
