package com.andreiyusupau.intarray;

import com.andreiyusupau.intarray.controller.ArrayController;
import com.andreiyusupau.intarray.dao.DAO;
import com.andreiyusupau.intarray.dao.DAOFactory;
import com.andreiyusupau.intarray.model.Array;
import com.andreiyusupau.intarray.service.ArrayService;
import com.andreiyusupau.intarray.service.search.ArraySearcher;
import com.andreiyusupau.intarray.service.search.ArraySearcherFactory;
import com.andreiyusupau.intarray.service.sort.ArraySorter;
import com.andreiyusupau.intarray.service.sort.ArraySorterFactory;
import com.andreiyusupau.intarray.util.PropertiesLoader;
import com.andreiyusupau.intarray.view.View;
import com.andreiyusupau.intarray.view.ViewFactory;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        DAO<Array> arrayDAO = DAOFactory.getDAO(propertiesLoader.getProperty("dao.type"));
        View view = ViewFactory.getView(propertiesLoader.getProperty("view.type"));
        ArraySorter arraySorter = ArraySorterFactory.getArraySorter(propertiesLoader.getProperty("arraysorter.type"));
        ArraySearcher arraySearcher = ArraySearcherFactory.getArraySearcher(propertiesLoader.getProperty("arraysearcher.type"));
        ArrayService arrayService = new ArrayService(arraySorter, arraySearcher, arrayDAO);
        ArrayController arrayController = new ArrayController(arrayService, view);
        arrayController.init();
    }
}
