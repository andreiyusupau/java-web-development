package com.andreiyusupau.library.dao.sort;

import com.andreiyusupau.library.model.Book;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberOfPagesComparatorTest {

    @Test
    void compareAscendingShouldReturnZero() {
        Comparator<Book> comparator = new NumberOfPagesComparator(true);
        Book firstBook = new Book(-1, "FirstBook", "Author1, Author2", 100, "MyPublisher");
        Book secondBook = new Book(-1, "SecondBook", "Author3, Author4", 100, "MyPublisher");

        int compareResult = comparator.compare(firstBook, secondBook);

        int expectedResult = 0;
        assertEquals(expectedResult, compareResult);
    }

    @Test
    void compareAscendingShouldReturnNumberGreaterThanZero() {
        Comparator<Book> comparator = new NumberOfPagesComparator(true);
        Book firstBook = new Book(-1, "FirstBook", "Author1, Author2", 105, "MyPublisher");
        Book secondBook = new Book(-1, "SecondBook", "Author3, Author4", 100, "MyPublisher");

        int compareResult = comparator.compare(firstBook, secondBook);

        assertTrue(compareResult > 0);
    }

    @Test
    void compareAscendingShouldReturnNumberLessThanZero() {
        Comparator<Book> comparator = new NumberOfPagesComparator(true);
        Book firstBook = new Book(-1, "FirstBook", "Author1, Author2", 100, "MyPublisher");
        Book secondBook = new Book(-1, "SecondBook", "Author3, Author4", 105, "MyPublisher");

        int compareResult = comparator.compare(firstBook, secondBook);

        assertTrue(compareResult < 0);
    }

    @Test
    void compareDescendingShouldReturnZero() {
        Comparator<Book> comparator = new NumberOfPagesComparator(false);
        Book firstBook = new Book(-1, "FirstBook", "Author1, Author2", 100, "MyPublisher");
        Book secondBook = new Book(-1, "SecondBook", "Author3, Author4", 100, "MyPublisher");

        int compareResult = comparator.compare(firstBook, secondBook);

        int expectedResult = 0;
        assertEquals(expectedResult, compareResult);
    }

    @Test
    void compareDescendingShouldReturnNumberGreaterThanZero() {
        Comparator<Book> comparator = new NumberOfPagesComparator(false);
        Book firstBook = new Book(-1, "FirstBook", "Author1, Author2", 100, "MyPublisher");
        Book secondBook = new Book(-1, "SecondBook", "Author3, Author4", 105, "MyPublisher");

        int compareResult = comparator.compare(firstBook, secondBook);

        assertTrue(compareResult > 0);
    }

    @Test
    void compareDescendingShouldReturnNumberLessThanZero() {
        Comparator<Book> comparator = new NumberOfPagesComparator(false);
        Book firstBook = new Book(-1, "FirstBook", "Author1, Author2", 105, "MyPublisher");
        Book secondBook = new Book(-1, "SecondBook", "Author3, Author4", 100, "MyPublisher");

        int compareResult = comparator.compare(firstBook, secondBook);

        assertTrue(compareResult < 0);
    }
}
