package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class NumberOfPagesComparatorTest {

    @Test
    void testCompareAscendingShouldReturnZero() {
        Comparator<Book> comparator = new NumberOfPagesComparator(true);
        Book firstBook = new Book(-1, "FirstBook", "Author1, Author2", 100, "MyPublisher");
        Book secondBook = new Book(-1, "SecondBook", "Author3, Author4", 100, "MyPublisher");

        int compareResult = comparator.compare(firstBook, secondBook);

        int expectedResult = 0;
        Assertions.assertEquals(expectedResult, compareResult);
    }

    @Test
    void testCompareAscendingShouldReturnNumberGreaterThanZero() {
        Comparator<Book> comparator = new NumberOfPagesComparator(true);
        Book firstBook = new Book(-1, "FirstBook", "Author1, Author2", 105, "MyPublisher");
        Book secondBook = new Book(-1, "SecondBook", "Author3, Author4", 100, "MyPublisher");

        int compareResult = comparator.compare(firstBook, secondBook);

        Assertions.assertTrue(compareResult > 0);
    }

    @Test
    void testCompareAscendingShouldReturnNumberLessThanZero() {
        Comparator<Book> comparator = new NumberOfPagesComparator(true);
        Book firstBook = new Book(-1, "FirstBook", "Author1, Author2", 100, "MyPublisher");
        Book secondBook = new Book(-1, "SecondBook", "Author3, Author4", 105, "MyPublisher");

        int compareResult = comparator.compare(firstBook, secondBook);

        Assertions.assertTrue(compareResult < 0);
    }

    @Test
    void testCompareDescendingShouldReturnZero() {
        Comparator<Book> comparator = new NumberOfPagesComparator(false);
        Book firstBook = new Book(-1, "FirstBook", "Author1, Author2", 100, "MyPublisher");
        Book secondBook = new Book(-1, "SecondBook", "Author3, Author4", 100, "MyPublisher");

        int compareResult = comparator.compare(firstBook, secondBook);

        int expectedResult = 0;
        Assertions.assertEquals(expectedResult, compareResult);
    }

    @Test
    void testCompareDescendingShouldReturnNumberGreaterThanZero() {
        Comparator<Book> comparator = new NumberOfPagesComparator(false);
        Book firstBook = new Book(-1, "FirstBook", "Author1, Author2", 100, "MyPublisher");
        Book secondBook = new Book(-1, "SecondBook", "Author3, Author4", 105, "MyPublisher");

        int compareResult = comparator.compare(firstBook, secondBook);

        Assertions.assertTrue(compareResult > 0);
    }

    @Test
    void testCompareDescendingShouldReturnNumberLessThanZero() {
        Comparator<Book> comparator = new NumberOfPagesComparator(false);
        Book firstBook = new Book(-1, "FirstBook", "Author1, Author2", 105, "MyPublisher");
        Book secondBook = new Book(-1, "SecondBook", "Author3, Author4", 100, "MyPublisher");

        int compareResult = comparator.compare(firstBook, secondBook);

        Assertions.assertTrue(compareResult < 0);
    }
}
