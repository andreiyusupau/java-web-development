package com.andreiyusupau.pointdistancecalculator.service;

import com.andreiyusupau.pointdistancecalculator.model.Point;

public class DistanceCalculator {

    public int comparePointDistances(Point pointA, Point pointB) {
        Point originPoint = new Point(0, 0);
        double distanceA = calculateDistance(originPoint, pointA);
        double distanceB = calculateDistance(originPoint, pointB);
        return compareDistances(distanceA, distanceB);
    }

    private double calculateDistance(Point point1, Point point2) {
        double side1 = Math.abs(point1.getX() - point2.getX());
        double side2 = Math.abs(point1.getY() - point2.getY());
        return Math.hypot(side1, side2);
    }

    private int compareDistances(double distanceA, double distanceB) {
        if (isEqual(distanceA, distanceB)) {
            return 0;
        } else if (distanceA > distanceB) {
            return 1;
        } else {
            return -1;
        }
    }

    private boolean isEqual(double distanceA, double distanceB) {
        return Math.abs(distanceA - distanceB) < Math.ulp(distanceA);
    }

}
