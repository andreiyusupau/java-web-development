package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PagesMoreThanSpecificationTest {

private final Specification<Book> pagesMoreThanSpecification = new PagesMoreThanSpecification(100);

    @Test
    void specifyShouldReturnFalse() {
        Book book = new Book(-1, "FirstBook", "Author1, Author2", 10, "MyPublisher");

        boolean specified=pagesMoreThanSpecification.specified(book);

        assertFalse(specified);
    }

    @Test
    void specifyShouldReturnTrue() {
        Book book = new Book(-1, "SecondBook", "Author3, Author4", 455, "MyPublisher");

        boolean specified=pagesMoreThanSpecification.specified(book);

        assertTrue(specified);
    }
}
