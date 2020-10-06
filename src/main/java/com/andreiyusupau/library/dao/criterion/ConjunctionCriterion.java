package com.andreiyusupau.library.dao.criterion;

import com.andreiyusupau.library.model.Book;

import java.util.List;

public class ConjunctionCriterion implements Criterion<Book> {

    private List<Criterion<Book>> criteria;

    public ConjunctionCriterion(List<Criterion<Book>> criteria) {
        this.criteria = criteria;
    }

    @Override
    public List<Book> filter(List<Book> t) {
        List<Book> result=t;
        for (Criterion<Book> criterion:criteria){
            result=criterion.filter(result);
        }
        return result;
    }
}
