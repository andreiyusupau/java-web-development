package com.andreiyusupau.intarray.service.sort;

public class ArraySorterFactory {
    public static ArraySorter getArraySorter(String type){
        switch (type.toLowerCase()){
            case "insertions":
                return new InsertionsArraySorter();
            default:
                throw new NoSuchArraySorterImplementationException("Array sorter referred to type \""+type+"\" does not exists.");
        }
    }
}
