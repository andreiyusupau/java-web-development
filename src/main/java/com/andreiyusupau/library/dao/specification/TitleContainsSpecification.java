package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;

public class TitleContainsSpecification implements Specification<Book> {

    private final String title;

    public TitleContainsSpecification(String title) {
        this.title = title;
    }

    @Override
    public boolean specified(Book book) {
       String bookTitle= book.getTitle();
       return bookTitle.contains(title);
    }
}
