package com.andreiyusupau.pointdistancecalculator;

import com.andreiyusupau.pointdistancecalculator.controller.PointController;
import com.andreiyusupau.pointdistancecalculator.dao.DAO;
import com.andreiyusupau.pointdistancecalculator.dao.DAOFactory;
import com.andreiyusupau.pointdistancecalculator.model.Point;
import com.andreiyusupau.pointdistancecalculator.service.PointService;
import com.andreiyusupau.pointdistancecalculator.view.View;
import com.andreiyusupau.pointdistancecalculator.view.ViewFactory;

public class Main {
    public static void main(String[] args) {
        DAOFactory daoFactory=DAOFactory.getInstance();
        DAO<Point> pointDAO = daoFactory.getConsoleInputPointDAO();
        PointService pointService = new PointService(pointDAO);
        ViewFactory viewFactory=ViewFactory.getInstance();
        View view = viewFactory.getConsoleView();
        PointController pointController = new PointController(pointService, view);
        pointController.comparePointDistances();
    }
}
