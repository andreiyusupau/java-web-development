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
        DAO<Point> pointDAO = DAOFactory.getDAO("console");
        PointService pointService = new PointService(pointDAO);
        View view = ViewFactory.getView("console");
        PointController pointController = new PointController(pointService, view);
        pointController.comparePointDistances();
    }
}
