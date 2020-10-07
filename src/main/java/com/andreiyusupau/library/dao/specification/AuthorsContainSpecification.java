package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;

public class AuthorsContainSpecification extends BasicSpecification<Book>{

    private final String author;

    public AuthorsContainSpecification(String author) {
        this.author = author;
    }

    @Override
    public boolean isSatisfactory(Book book) {
        return book.getAuthors().contains(author);
    }
}


