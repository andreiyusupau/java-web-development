package com.andreiyusupau.stringprocessor.service;

import com.andreiyusupau.stringprocessor.dao.DAO;
import com.andreiyusupau.stringprocessor.model.StringInputParameters;

public class StringProcessingService {

   private final SymbolReplacer symbolReplacer;
   private final DAO<StringInputParameters> stringInputParametersDAO;

    public StringProcessingService(SymbolReplacer symbolReplacer, DAO<StringInputParameters> stringInputParametersDAO) {
        this.symbolReplacer = symbolReplacer;
        this.stringInputParametersDAO = stringInputParametersDAO;
    }

    public String process(){
        StringInputParameters stringInputParameters=stringInputParametersDAO.get();
       return symbolReplacer.replaceSymbol(stringInputParameters.getInput(),stringInputParameters.getCharPosition(),
                stringInputParameters.getCharToReplace());
    }
}
