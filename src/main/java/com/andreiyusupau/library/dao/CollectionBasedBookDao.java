package com.andreiyusupau.library.dao;

import com.andreiyusupau.library.dao.exception.DataAccessException;
import com.andreiyusupau.library.dao.specification.Specification;
import com.andreiyusupau.library.dao.util.IdGenerator;
import com.andreiyusupau.library.model.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CollectionBasedBookDao implements Dao<Book> {

    private final List<Book> bookList = new ArrayList<>();
    private final IdGenerator idGenerator;

    public CollectionBasedBookDao(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public long add(Book bookToAdd) {
        if (!bookList.contains(bookToAdd)) {
            Book book = getBookWithId(bookToAdd);
            bookList.add(book);
            return book.getId();
        } else {
            throw new DataAccessException("Can't add " + bookToAdd.toString() + " because it already exists.");
        }
    }

    private Book getBookWithId(Book book) {
        long id = idGenerator.getNextId();
        String title = book.getTitle();
        String authors = book.getAuthors();
        String publisher = book.getPublisher();
        int numberOfPages = book.getNumberOfPages();
        return new Book(id, title, authors, numberOfPages, publisher);
    }

    @Override
    public boolean remove(long id) {
        Collection<Book> book2 = new HashSet<>();
        for (Book book : bookList) {
            if (book.getId() == id) {
                return bookList.remove(book);
            }
        }
        throw new DataAccessException("Can't remove book with id=" + id + " because it doesn't exist.");
    }

    @Override
    public List<Book> find(Specification<Book> specifications) {
        return specifications.specify(bookList);
    }
}
