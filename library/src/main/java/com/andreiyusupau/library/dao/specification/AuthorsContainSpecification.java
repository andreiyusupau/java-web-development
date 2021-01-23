package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;

public class AuthorsContainSpecification implements Specification<Book> {

    private final String author;

    public AuthorsContainSpecification(String author) {
        this.author = author;
    }

    @Override
    public boolean specified(Book book) {
        String authors=book.getAuthors();
        return authors.contains(author);
    }
}


