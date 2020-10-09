package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConjunctionSpecificationTest {

    @Test
    void testSpecifyShouldReturnListFilteredByAuthorAndSortedByNumberOfPagesAscending() {
        List<Book> initialList = new ArrayList<>();
        Book firstBook = new Book(-1, "FirstBook", "Author1, Author2", 10, "MyPublisher");
        Book secondBook = new Book(-1, "SecondBook", "Author3, Author4", 455, "MyPublisher");
        Book thirdBook = new Book(-1, "ThirdBook", "Author3, Author1", 78, "MyPublisher");
        Book fourthBook = new Book(-1, "FourthBook", "Author4, Author3", 300, "MyPublisher");
        initialList.add(firstBook);
        initialList.add(secondBook);
        initialList.add(thirdBook);
        initialList.add(fourthBook);

        Specification<Book> authorsContainSpecification = new AuthorsContainSpecification("Author3");
        Comparator<Book> bookComparator = new NumberOfPagesComparator(true);
        Specification<Book> numberOfPagesSortSpecification = new SortByNumberOfPagesSpecification(bookComparator);
        List<Specification<Book>> specificationList=new ArrayList<>();
        specificationList.add(authorsContainSpecification);
        specificationList.add(numberOfPagesSortSpecification);
        Specification<Book> conjunctionSpecification=new ConjunctionSpecification(specificationList);
        List<Book> filteredAndSortedList = conjunctionSpecification.specify(initialList);

        List<Book> expectedList = new ArrayList<>();
        expectedList.add(thirdBook);
        expectedList.add(fourthBook);
        expectedList.add(secondBook);
        Assertions.assertEquals(expectedList, filteredAndSortedList);
    }
}
