package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class TitleContainsSpecification implements Specification<Book> {

    private final String title;

    public TitleContainsSpecification(String title) {
        this.title = title;
    }

    @Override
    public List<Book> specify(List<Book> t) {
        List<Book> books = new ArrayList<>();
        for (Book book : t) {
            if (book.getTitle().contains(title)) {
                books.add(book);
            }
        }
        return books;
    }


}
