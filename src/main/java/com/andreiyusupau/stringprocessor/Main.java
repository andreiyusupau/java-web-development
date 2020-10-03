package com.andreiyusupau.stringprocessor;

import com.andreiyusupau.stringprocessor.controller.StringController;
import com.andreiyusupau.stringprocessor.dao.DAO;
import com.andreiyusupau.stringprocessor.dao.DAOFactory;
import com.andreiyusupau.stringprocessor.model.StringInputParameters;
import com.andreiyusupau.stringprocessor.service.StringProcessingService;
import com.andreiyusupau.stringprocessor.service.SymbolReplacer;
import com.andreiyusupau.stringprocessor.service.SymbolReplacerFactory;
import com.andreiyusupau.stringprocessor.util.PropertiesLoader;
import com.andreiyusupau.stringprocessor.view.View;
import com.andreiyusupau.stringprocessor.view.ViewFactory;

public class Main {

    public static void main(String[] args) {
run();
    }

    public static void run(){
        PropertiesLoader propertiesLoader=new PropertiesLoader();
        DAO<StringInputParameters> stringInputParametersDAO= DAOFactory.getDAO(propertiesLoader.getProperty("dao.type"));
        SymbolReplacer symbolReplacer= SymbolReplacerFactory.getSymbolReplacer(propertiesLoader.getProperty("symbolreplacer.type"));
        StringProcessingService stringProcessingService=new StringProcessingService(symbolReplacer,stringInputParametersDAO);
        View view= ViewFactory.getView(propertiesLoader.getProperty("view.type"));
        StringController stringController=new StringController(stringProcessingService,view);
        stringController.process();
    }
}
