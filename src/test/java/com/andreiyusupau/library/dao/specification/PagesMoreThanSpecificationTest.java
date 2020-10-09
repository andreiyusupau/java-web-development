package com.andreiyusupau.library.dao.specification;

import com.andreiyusupau.library.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PagesMoreThanSpecificationTest {

    @Test
    void testSpecifyShouldReturnListOfBooksWhichHaveMoreThanOneHundredPages() {
        List<Book> initialList = new ArrayList<>();
        Book firstBook = new Book(-1, "FirstBook", "Author1, Author2", 10, "MyPublisher");
        Book secondBook = new Book(-1, "SecondBook", "Author3, Author4", 455, "MyPublisher");
        Book thirdBook = new Book(-1, "ThirdBook", "Author3, Author1", 78, "MyPublisher");
        Book fourthBook = new Book(-1, "FourthBook", "Author4, Author5", 300, "MyPublisher");
        initialList.add(firstBook);
        initialList.add(secondBook);
        initialList.add(thirdBook);
        initialList.add(fourthBook);

        Specification<Book> pagesMoreThanSpecification = new PagesMoreThanSpecification(100);
        List<Book> filteredList = pagesMoreThanSpecification.specify(initialList);

        List<Book> expectedList = new ArrayList<>();
        expectedList.add(secondBook);
        expectedList.add(fourthBook);

        Assertions.assertEquals(expectedList, filteredList);
    }
}
