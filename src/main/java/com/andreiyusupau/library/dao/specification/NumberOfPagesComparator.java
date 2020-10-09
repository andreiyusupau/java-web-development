package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;

import java.util.Comparator;

public class NumberOfPagesComparator implements Comparator<Book> {

    private final boolean ascending;

    public NumberOfPagesComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Book firstBook, Book secondBook) {
        int numberOfPagesDelta = firstBook.getNumberOfPages() - secondBook.getNumberOfPages();
        return ascending ? numberOfPagesDelta : -numberOfPagesDelta;
    }
}

