package com.andreiyusupau.library.dao.criterion;

import com.andreiyusupau.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class PagesMoreThanCriterion implements  Criterion<Book> {

    private final int numberOfPages;

    public PagesMoreThanCriterion(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public List<Book> filter(List<Book> t) {
        List<Book> books = new ArrayList<>();
        for (Book book : t) {
            if (book.getNumberOfPages()>numberOfPages) {
                books.add(book);
            }
        }
        return books;
    }
}
