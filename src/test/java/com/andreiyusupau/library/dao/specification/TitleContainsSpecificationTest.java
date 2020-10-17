package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TitleContainsSpecificationTest {

    private  final     Specification<Book> titleContainsSpecification = new TitleContainsSpecification("dBook");
    @Test
    void specifyShouldReturnTrue() {
        Book book = new Book(-1, "SecondBook", "Author3, Author4", 455, "MyPublisher");

        boolean specified = titleContainsSpecification.specified(book);

        assertTrue(specified);
    }

    @Test
    void specifyShouldReturnFalse() {
        Book book = new Book(-1, "FirstBook", "Author1, Author2", 10, "MyPublisher");

        boolean specified = titleContainsSpecification.specified(book);

        assertFalse(specified);
    }
}
