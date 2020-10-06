package com.andreiyusupau.library.dao.criterion;

import com.andreiyusupau.library.model.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortByNumberOfPagesCriterion implements Criterion<Book> {

    private final boolean ascending;

    public SortByNumberOfPagesCriterion(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public List<Book> filter(List<Book> t) {
        List<Book> books = new ArrayList<>(t);
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return ascending ? o1.getNumberOfPages() - o2.getNumberOfPages() : o2.getNumberOfPages() - o1.getNumberOfPages();
            }
        });
        return books;
    }
}

