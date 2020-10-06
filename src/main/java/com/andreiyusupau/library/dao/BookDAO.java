package com.andreiyusupau.library.dao;

import com.andreiyusupau.library.dao.criterion.Criterion;
import com.andreiyusupau.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO implements DAO<Book> {

    private final List<Book> bookList = new ArrayList<>();
    private long currentId = 0;

    @Override
    public long add(Book book) {
        if (!bookList.contains(book)) {
            book.setId(currentId);
            currentId++;
            bookList.add(book);
            return book.getId();
        } else {
            throw new DataAccessException("Can't add " + book.toString() + " because it already exists.");
        }
    }

    @Override
    public boolean remove(long id) {
        for (Book book : bookList) {
            if (book.getId() == id) {
                return bookList.remove(book);
            }
        }
        throw new DataAccessException("Can't remove with id=" + id + " because it doesn't exist.");
    }


    @Override
    public List<Book> find(Criterion<Book> criteria) {
        return criteria.filter(bookList);
    }
}
