package com.andreiyusupau.pointdistancecalculator.service;

import com.andreiyusupau.pointdistancecalculator.model.Point;

public class DistanceCalculator {

    public int comparePointDistances(Point pointA, Point pointB){
        Point originPoint = new Point(0, 0);
        double distanceA = calculateDistance(originPoint, pointA);
        double distanceB = calculateDistance(originPoint, pointB);
        return compareDistances(distanceA, distanceB);
    }

    private double calculateDistance(Point point1, Point point2) {
        return Math.sqrt((point1.getX() - point2.getX()) * (point1.getX() - point2.getX()) + (point1.getY() - point2.getY()) * (point1.getY() - point2.getY()));
    }

    private int compareDistances(double distanceA,double distanceB){
        return Double.compare(distanceA, distanceB);
    }

}
