package com.andreiyusupau.library.dao;

import com.andreiyusupau.library.dao.exception.DataAccessException;
import com.andreiyusupau.library.dao.specification.Specification;
import com.andreiyusupau.library.dao.specification.TitleContainsSpecification;
import com.andreiyusupau.library.dao.util.BasicIdGenerator;
import com.andreiyusupau.library.dao.util.IdGenerator;
import com.andreiyusupau.library.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CollectionBasedBookDaoTest {

    @Test
    void testAddShouldAddThreeBooks() {
        IdGenerator idGenerator = new BasicIdGenerator();
        Dao<Book> bookDao = new CollectionBasedBookDao(idGenerator);
        bookDao.add(new Book(-1, "FirstBook", "Its authors", 42, "MyPublisher"));
        bookDao.add(new Book(-1, "SecondBook", "Its authors", 532, "MyPublisher"));
        bookDao.add(new Book(-1, "LastBook", "Its authors", 642, "MyPublisher"));
        Specification<Book> emptySpecification = new TitleContainsSpecification("");
        List<Book> books = bookDao.find(emptySpecification);
        int booksCount = books.size();
        int expectedCount = 3;
        Assertions.assertEquals(expectedCount, booksCount);
    }

    @Test
    void testAddShouldThrowException() {
        IdGenerator idGenerator = new BasicIdGenerator();
        Dao<Book> bookDao = new CollectionBasedBookDao(idGenerator);
        Book firstBook = new Book(-1, "FirstBook", "Its authors", 42, "MyPublisher");
        bookDao.add(firstBook);
        Book secondBook = new Book(-1, "FirstBook", "Its authors", 42, "MyPublisher");

        Throwable throwable = Assertions.assertThrows(DataAccessException.class, () -> bookDao.add(secondBook));
        String actualMessage = throwable.getMessage();

        String expectedMessage = "Can't add " + secondBook.toString() + " because it already exists.";
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testRemove() {
        IdGenerator idGenerator = new BasicIdGenerator();
        Dao<Book> bookDao = new CollectionBasedBookDao(idGenerator);
        bookDao.add(new Book(-1, "FirstBook", "Its authors", 42, "MyPublisher"));
        bookDao.add(new Book(-1, "SecondBook", "Its authors", 532, "MyPublisher"));
        bookDao.add(new Book(-1, "LastBook", "Its authors", 642, "MyPublisher"));
        Specification<Book> emptySpecification = new TitleContainsSpecification("");
        List<Book> books = bookDao.find(emptySpecification);
        int booksCount = books.size();
        int expectedCount = 3;
        Assertions.assertEquals(expectedCount, booksCount);
    }

    @Test
    void testRemoveShouldThrowException() {
        IdGenerator idGenerator = new BasicIdGenerator();
        Dao<Book> bookDao = new CollectionBasedBookDao(idGenerator);
        Book firstBook = new Book(-1, "FirstBook", "Its authors", 42, "MyPublisher");
        bookDao.add(firstBook);
        long bookIdToRemove = -1;

        Throwable throwable = Assertions.assertThrows(DataAccessException.class, () -> bookDao.remove(bookIdToRemove));
        String actualMessage = throwable.getMessage();

        String expectedMessage = "Can't remove book with id=" + bookIdToRemove + " because it doesn't exist.";
        Assertions.assertEquals(expectedMessage, actualMessage);
    }


}
