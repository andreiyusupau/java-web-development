package com.andreiyusupau.library.dao;

import com.andreiyusupau.library.dao.exception.DataAccessException;
import com.andreiyusupau.library.dao.specification.Specification;
import com.andreiyusupau.library.dao.util.IdGenerator;
import com.andreiyusupau.library.model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionBasedBookDao implements Dao<Book> {

    private final List<Book> bookList = new ArrayList<>();
    private final IdGenerator idGenerator;
    private static final Logger logger = LogManager.getLogger(CollectionBasedBookDao.class);

    public CollectionBasedBookDao(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public long add(Book bookToAdd) {
        if (!bookList.contains(bookToAdd)) {
            Book book = getBookWithId(bookToAdd);
            bookList.add(book);
            logger.info("Book "+book+" has been added to the collection.");
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
        for (Book book : bookList) {
            if (book.getId() == id) {
                logger.info("Book with id "+id+" has been removed from the collection.");
                return bookList.remove(book);
            }
        }
        throw new DataAccessException("Can't remove book with id=" + id + " because it doesn't exist.");
    }

    @Override
    public List<Book> find(Specification<Book> specification) {
        List<Book> specifiedBooks=new ArrayList<>();
        for(Book book:bookList){
            if(specification.specified(book)){
                specifiedBooks.add(book);
            }
        }
        return specifiedBooks;
    }

    @Override
    public List<Book> findSorted(Specification<Book> specification, Comparator<Book> comparator) {
        List<Book> sortedBooks=find(specification);
        sortedBooks.sort(comparator);
        return sortedBooks;
    }
}
