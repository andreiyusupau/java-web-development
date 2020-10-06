package com.andreiyusupau.library.dao.criterion;

import com.andreiyusupau.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class TitleContainsCriterion implements Criterion<Book> {

    private final String title;

    public TitleContainsCriterion(String title) {
        this.title = title;
    }

    @Override
    public List<Book> filter(List<Book> t) {
        List<Book> books = new ArrayList<>();
        for (Book book : t) {
            if (book.getTitle().contains(title)) {
                books.add(book);
            }
        }
        return books;
    }


}
