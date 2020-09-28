package com.andreiyusupau.intarray.dao;


import com.andreiyusupau.intarray.model.Array;

public class DAOFactory {

    public static DAO<Array> getDAO(String type){
        switch (type.toLowerCase()){
            case "console":
                return new ConsoleInputArrayDAO();
            case "file":
                return new FileArrayDAO();
            case "random":
                return new RandomArrayDAO();
            default:
                throw new NoSuchDAOImplementationException("DAO referred to type \""+type+"\" does not exists.");
        }
    }

}
