package com.andreiyusupau.pointdistancecalculator;

import com.andreiyusupau.pointdistancecalculator.controller.PointController;
import com.andreiyusupau.pointdistancecalculator.dao.DAO;
import com.andreiyusupau.pointdistancecalculator.dao.DAOFactory;
import com.andreiyusupau.pointdistancecalculator.model.Point;
import com.andreiyusupau.pointdistancecalculator.service.PointService;
import com.andreiyusupau.pointdistancecalculator.util.PropertiesLoader;
import com.andreiyusupau.pointdistancecalculator.view.View;
import com.andreiyusupau.pointdistancecalculator.view.ViewFactory;

public class Main {
    public static void main(String[] args) {
        PropertiesLoader propertiesLoader=new PropertiesLoader();
        DAO<Point> pointDAO = DAOFactory.getDAO(propertiesLoader.getProperty("dao.type"));
        PointService pointService = new PointService(pointDAO);
        View view = ViewFactory.getView(propertiesLoader.getProperty("view.type"));
        PointController pointController = new PointController(pointService, view);
        pointController.comparePointDistances();
    }
}
