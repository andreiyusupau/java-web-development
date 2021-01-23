package com.andreiyusupau.stringprocessor.dao;

import com.andreiyusupau.stringprocessor.model.StringInputParameters;

public class DAOFactory {

    public static DAO<StringInputParameters> getDAO(String type){
        switch (type.toLowerCase()){
            case "console":
                return new ConsoleStringDAO();
            case "file":
                return new FileStringDAO();
            default:
                throw new NoSuchDAOImplementationException("DAO referred to type \""+type+"\" does not exists.");
        }
    }

}
