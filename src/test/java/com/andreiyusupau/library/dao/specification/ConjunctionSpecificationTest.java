package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConjunctionSpecificationTest {
    @Mock
    private Specification<Book> firstSpecification;
    @Mock
    private Specification<Book> secondSpecification;
    private List<Specification<Book>> specificationList;
    private Specification<Book> conjunctionSpecification;
    private Book book;

    @BeforeEach
    void set(){
        specificationList = List.of(firstSpecification, secondSpecification);
        conjunctionSpecification = new ConjunctionSpecification(specificationList);
        book = new Book(-1, "FirstBook", "Author1, Author2", 100, "MyPublisher");
    }

    @Test
    void specifyShouldReturnTrue() {
        when(firstSpecification.specified(any()))
                .thenReturn(true);
        when(secondSpecification.specified(any()))
                .thenReturn(true);

        boolean specified = conjunctionSpecification.specified(book);

        Assertions.assertTrue(specified);
    }

    @Test
    void specifyShouldReturnFalse() {
        when(firstSpecification.specified(any()))
                .thenReturn(true);
        when(secondSpecification.specified(any()))
                .thenReturn(false);

        boolean specified = conjunctionSpecification.specified(book);

        Assertions.assertFalse(specified);
    }
}
