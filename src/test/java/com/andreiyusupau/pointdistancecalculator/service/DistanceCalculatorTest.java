package com.andreiyusupau.pointdistancecalculator.service;

import com.andreiyusupau.pointdistancecalculator.model.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DistanceCalculatorTest {

    @Test
    void comparePointDistancesIsEqualZeroBetweenNotZeroPoints() {
        Point point1 = new Point(2, 3);
        Point point2 = new Point(3, 2);
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        int compareResult = distanceCalculator.comparePointDistances(point1, point2);
        Assertions.assertEquals(0, compareResult);
    }

    @Test
    void comparePointDistancesIsEqualZeroBetweenSameNotZeroPoints() {
        Point point1 = new Point(2, 3);
        Point point2 = new Point(2, 3);
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        int compareResult = distanceCalculator.comparePointDistances(point1, point2);
        Assertions.assertEquals(0, compareResult);
    }

    @Test
    void comparePointDistancesIsEqualZeroBetweenZeroPoints() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        int compareResult = distanceCalculator.comparePointDistances(point1, point2);
        Assertions.assertEquals(0, compareResult);
    }

    @Test
    void comparePointDistancesIsEqualOneWhenFirstPointIsMoreRemoteFromTheOrigin() {
        Point point1 = new Point(4, 3);
        Point point2 = new Point(0, 0);
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        int compareResult = distanceCalculator.comparePointDistances(point1, point2);
        Assertions.assertEquals(1, compareResult);
    }

    @Test
    void comparePointDistancesIsEqualOneWhenFirstPointIsNegativeAndIsMoreRemoteFromTheOrigin() {
        Point point1 = new Point(-4, -3);
        Point point2 = new Point(0, 0);
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        int compareResult = distanceCalculator.comparePointDistances(point1, point2);
        Assertions.assertEquals(1, compareResult);
    }

    @Test
    void comparePointDistancesIsEqualMinusOneWhenSecondPointIsMoreRemoteFromTheOrigin() {
        Point point1 = new Point(4, 3);
        Point point2 = new Point(25, 1);
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        int compareResult = distanceCalculator.comparePointDistances(point1, point2);
        Assertions.assertEquals(-1, compareResult);
    }

    @Test
    void comparePointDistancesIsEqualOneWhenSecondPointIsNegativeAndIsMoreRemoteFromTheOrigin() {
        Point point1 = new Point(5, -3);
        Point point2 = new Point(-129, 0);
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        int compareResult = distanceCalculator.comparePointDistances(point1, point2);
        Assertions.assertEquals(-1, compareResult);
    }

}
