package com.andreiyusupau.pointdistancecalculator.dao;


public class DAOFactory {
    private static DAOFactory instance;

    private DAOFactory(){

    }

    public ConsoleInputPointDAO getConsoleInputPointDAO(){
        return new ConsoleInputPointDAO();
    }

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }
}
