package com.andreiyusupau.library.dao.criterion;

import com.andreiyusupau.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class AuthorsContainCriterion implements  Criterion<Book> {

    private final String author;

    public AuthorsContainCriterion(String author) {
        this.author = author;
    }

    @Override
    public List<Book> filter(List<Book> t) {
        List<Book> books = new ArrayList<>();
        for (Book book : t) {
            if (book.getAuthors().contains(author)) {
                books.add(book);
            }
        }
        return books;
    }
}


