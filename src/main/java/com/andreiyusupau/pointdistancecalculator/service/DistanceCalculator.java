package com.andreiyusupau.pointdistancecalculator.service;

import com.andreiyusupau.pointdistancecalculator.dao.DAO;
import com.andreiyusupau.pointdistancecalculator.model.Point;

public class DistanceCalculator {

    private final DAO<Point> pointDAO;

    public DistanceCalculator(DAO<Point> pointDAO) {
        this.pointDAO = pointDAO;
    }

    public String getResult() {
        Point pointA = pointDAO.get();
        Point pointB = pointDAO.get();
        Point originPoint = new Point(0, 0);
        double distanceA = calculateDistance(originPoint, pointA);
        double distanceB = calculateDistance(originPoint, pointB);
        int compareResult = Double.compare(distanceA, distanceB);
        switch (compareResult) {
            case 1:
                return "Point B is closer to origin point than point A.";
            case -1:
                return "Point A is closer to origin point than point B.";
            default:
                return "Distances from point A and point B to origin point are equal.";
        }
    }

    public static double calculateDistance(Point point1, Point point2) {
        return Math.sqrt((point1.getX() - point2.getX()) * (point1.getX() - point2.getX()) + (point1.getY() - point2.getY()) * (point1.getY() - point2.getY()));
    }

}
