package com.andreiyusupau.numbercalculator.dao;


public class DAOFactory {

    public static DAO<Long> getDAO(String type){
        switch (type.toLowerCase()){
            case "file":
                return new FileNumberDAO();
            default:
                throw new NoSuchDAOImplementation("DAO referred to type \""+type+"\" does not exists.");
        }
    }

    private static class NoSuchDAOImplementation extends RuntimeException {

        public NoSuchDAOImplementation(String errorMessage){
            super(errorMessage);
        }
    }
}
