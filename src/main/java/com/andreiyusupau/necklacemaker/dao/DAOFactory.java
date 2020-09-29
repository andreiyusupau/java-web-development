package com.andreiyusupau.necklacemaker.dao;


import com.andreiyusupau.necklacemaker.model.Gem;

public class DAOFactory {

    public static DAO<Gem> getDAO(String type){
        switch (type.toLowerCase()){
            case "console":
                return new ConsoleGemDAO();
            default:
                throw new NoSuchDAOImplementationException("DAO referred to type \""+type+"\" does not exists.");
        }
    }

}
