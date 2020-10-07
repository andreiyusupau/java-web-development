package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortByNumberOfPagesSpecification implements Specification<Book> {

    private final Comparator<Book> bookComparator;

    public SortByNumberOfPagesSpecification(Comparator<Book> bookComparator) {
        this.bookComparator = bookComparator;
    }

    @Override
    public List<Book> specify(List<Book> t) {
        List<Book> books = new ArrayList<>(t);
        books.sort(bookComparator);
        return books;
    }
}

