package com.andreiyusupau.pointdistancecalculator.service;

import com.andreiyusupau.pointdistancecalculator.dao.DAO;
import com.andreiyusupau.pointdistancecalculator.model.Point;

public class PointService {
    private final DAO<Point> pointDAO;

    public PointService(DAO<Point> pointDAO) {
        this.pointDAO = pointDAO;
    }

    public String getResult() {
        Point pointA = pointDAO.get();
        Point pointB = pointDAO.get();
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        int compareResult = distanceCalculator.comparePointDistances(pointA, pointB);
        return createResponseMessage(compareResult);
    }

    private String createResponseMessage(int compareResult) {
        switch (compareResult) {
            case 1:
                return "Point B is closer to origin point than point A.";
            case -1:
                return "Point A is closer to origin point than point B.";
            default:
                return "Distances from point A and point B to origin point are equal.";
        }
    }
}
