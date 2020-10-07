package com.andreiyusupau.library.dao;

import com.andreiyusupau.library.dao.specification.Specification;
import com.andreiyusupau.library.dao.specification.TitleContainsSpecification;
import com.andreiyusupau.library.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CollectionBasedBookDaoTest {

    @Test
    void testAdd(){
        IdGenerator idGenerator =new BasicIdGenerator();
        Dao<Book> bookDao=new CollectionBasedBookDao(idGenerator);
        bookDao.add(new Book(-1,"FirstBook","Its authors",42,"MyPublisher"));
        bookDao.add(new Book(-1,"SecondBook","Its authors",532,"MyPublisher"));
        bookDao.add(new Book(-1,"LastBook","Its authors",642,"MyPublisher"));
        Specification<Book> emptySpecification = new TitleContainsSpecification("");
        List<Book> books=bookDao.find(emptySpecification);
        int booksCount=books.size();
int expectedCount=3;
        Assertions.assertEquals(expectedCount,booksCount);
    }

    @Test
    void testRemove(){
        IdGenerator idGenerator =new BasicIdGenerator();
        Dao<Book> bookDao=new CollectionBasedBookDao(idGenerator);
        bookDao.add(new Book(-1,"FirstBook","Its authors",42,"MyPublisher"));
        bookDao.add(new Book(-1,"SecondBook","Its authors",532,"MyPublisher"));
        bookDao.add(new Book(-1,"LastBook","Its authors",642,"MyPublisher"));
        Specification<Book> emptySpecification = new TitleContainsSpecification("");
        List<Book> books=bookDao.find(emptySpecification);
        int booksCount=books.size();
        int expectedCount=3;
        Assertions.assertEquals(expectedCount,booksCount);
    }

    @Test
    void testFind(){

    }
}
