package com.andreiyusupau.library;

import com.andreiyusupau.library.dao.BookDAO;
import com.andreiyusupau.library.dao.DAO;
import com.andreiyusupau.library.dao.criterion.ConjunctionCriterion;
import com.andreiyusupau.library.dao.criterion.Criterion;
import com.andreiyusupau.library.dao.criterion.SortByNumberOfPagesCriterion;
import com.andreiyusupau.library.dao.criterion.TitleContainsCriterion;
import com.andreiyusupau.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DAO<Book> bookDAO = new BookDAO();
        Book book = new Book();
        book.setTitle("Atlas Shrugged");
        book.setAuthors("Rand");
        book.setPublisher("ROSMEN");
        book.setNumberOfPages(500);
        Book book2 = new Book();
        book2.setTitle("Atlas Shrugged 2");
        book2.setAuthors("Rand");
        book2.setPublisher("ROSMEN");
        book2.setNumberOfPages(200);
        Book book3 = new Book();
        book3.setTitle("Atlas Shrugged 3");
        book3.setAuthors("Rand2 Rand1");
        book3.setPublisher("ROSMEN");
        book3.setNumberOfPages(800);

        Book book4 = new Book();
        book4.setTitle("Atlas6 Shrugged 63");
        book4.setAuthors("Rand2 Rand1");
        book4.setPublisher("ROSMEN2");
        book4.setNumberOfPages(600);
        bookDAO.add(book);
        bookDAO.add(book2);
        bookDAO.add(book4);
        Criterion<Book> criterion = new SortByNumberOfPagesCriterion(true);
        Criterion<Book> criterion1 = new TitleContainsCriterion("Atlas");
        List<Criterion<Book>> criterionList = new ArrayList<>();
        criterionList.add(criterion);
        criterionList.add(criterion1);
        Criterion<Book> conjunction = new ConjunctionCriterion(criterionList);
        System.out.println(bookDAO.find(conjunction).toString());
    }
}
