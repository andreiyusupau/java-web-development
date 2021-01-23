package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuthorsContainSpecificationTest {

    @Test
    void specifyShouldReturnTrue() {
        Book book = new Book(-1, "FirstBook", "Author1, Author3", 10, "MyPublisher");
        Specification<Book> authorsContainSpecification = new AuthorsContainSpecification("Author3");

        boolean specified=  authorsContainSpecification.specified(book);

        assertTrue(specified);
    }

    @Test
    void specifyShouldReturnFalse() {
        Book book = new Book(-1, "SecondBook", "Author2, Author4", 455, "MyPublisher");
        Specification<Book> authorsContainSpecification = new AuthorsContainSpecification("Author3");

        boolean specified=  authorsContainSpecification.specified(book);

        assertFalse(specified);
    }
}
