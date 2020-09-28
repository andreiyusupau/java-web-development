package com.andreiyusupau.intarray.service.search;

import com.andreiyusupau.intarray.view.NoSuchViewImplementationException;

public class ArraySearcherFactory {

    public static ArraySearcher getArraySearcher(String type){
        switch (type.toLowerCase()){
            case "binary":
                return new BinaryArraySearcher();
            default:
                throw new NoSuchArraySearcherImplementationException("Array searcher referred to type \""+type+"\" does not exists.");
        }
    }
}
