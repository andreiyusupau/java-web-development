package com.andreiyusupau.library.dao;

import com.andreiyusupau.library.dao.exception.DataAccessException;
import com.andreiyusupau.library.dao.specification.Specification;
import com.andreiyusupau.library.dao.util.IdGenerator;
import com.andreiyusupau.library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CollectionBasedBookDaoTest {

    @Mock
    private IdGenerator idGenerator;
    @InjectMocks
    private CollectionBasedBookDao bookDao;
    @Mock
    private Specification<Book> specification;
    @Mock
    private Comparator<Book> comparator;
    private Book firstBook;
    private Book secondBook;
    private Book thirdBook;

    @BeforeEach
    void set() {
        firstBook = new Book(-1, "FirstBook", "Its authors", 42, "MyPublisher");
        secondBook = new Book(-1, "SecondBook", "Its authors", 532, "MyPublisher");
        thirdBook = new Book(-1, "ThirdBook", "Its authors", 642, "MyPublisher");
    }

    @Test
    void addShouldAddThreeBooks() {
        when(idGenerator.getNextId())
                .thenReturn(1L)
                .thenReturn(2L)
                .thenReturn(3L);

        bookDao.add(firstBook);
        bookDao.add(secondBook);
        bookDao.add(thirdBook);

        verify(idGenerator, times(3)).getNextId();
    }

    @Test
    void addShouldThrowException() {
        when(idGenerator.getNextId())
                .thenReturn(1L)
                .thenReturn(2L)
                .thenReturn(3L);
        bookDao.add(firstBook);

        Throwable throwable = assertThrows(DataAccessException.class, () -> bookDao.add(firstBook));
        String actualMessage = throwable.getMessage();

        String expectedMessage = "Can't add " + firstBook.toString() + " because it already exists.";
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void removeShouldNotThrowException() {
        when(idGenerator.getNextId())
                .thenReturn(1L)
                .thenReturn(2L)
                .thenReturn(3L);
        bookDao.add(firstBook);
        bookDao.add(secondBook);
        bookDao.add(thirdBook);

        bookDao.remove(1);
    }

    @Test
    void removeShouldThrowException() {
        Throwable throwable = assertThrows(DataAccessException.class, () -> bookDao.remove(-1));
        String actualMessage = throwable.getMessage();

        String expectedMessage = "Can't remove book with id=" + -1 + " because it doesn't exist.";
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void findShouldReturnAListOfTwoBooks() {
        when(idGenerator.getNextId())
                .thenReturn(1L)
                .thenReturn(2L)
                .thenReturn(3L);
        bookDao.add(firstBook);
        bookDao.add(secondBook);
        bookDao.add(thirdBook);

        when(specification.specified(any(Book.class)))
                .thenReturn(true)
                .thenReturn(false)
                .thenReturn(true);
        List<Book> foundBooks = bookDao.find(specification);
        int booksCount = foundBooks.size();
        assertEquals(2, booksCount);
    }

    @Test
    void findSortedShouldReturnAListOfTwoBooksSortedByNumberOfPagesDescending() {
        when(idGenerator.getNextId())
                .thenReturn(1L)
                .thenReturn(2L)
                .thenReturn(3L);
        bookDao.add(firstBook);
        bookDao.add(secondBook);
        bookDao.add(thirdBook);

        when(specification.specified(any(Book.class)))
                .thenReturn(true)
                .thenReturn(false)
                .thenReturn(true);
        when(comparator.compare(thirdBook, firstBook))
                .thenReturn(-1);
        List<Book> foundBooks = bookDao.findSorted(specification, comparator);
        List<Book> expectedBooks = List.of(thirdBook, firstBook);
        assertEquals(expectedBooks, foundBooks);
    }

}
