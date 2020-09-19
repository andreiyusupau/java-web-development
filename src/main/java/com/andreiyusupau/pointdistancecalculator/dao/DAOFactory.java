package com.andreiyusupau.pointdistancecalculator.dao;


import com.andreiyusupau.pointdistancecalculator.model.Point;

public class DAOFactory {

    public static DAO<Point> getDAO(String type){
        switch (type.toLowerCase()){
            case "console":
                return new ConsoleInputPointDAO();
            default:
                throw new NoSuchDAOImplementation("DAO referred to type \""+type+"\" does not exists.");
        }
    }

}
