package com.andreiyusupau.pointdistancecalculator.service;

import com.andreiyusupau.pointdistancecalculator.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class DistanceCalculatorTest {

    @Test
    public void calculateDistanceIsEqualZeroBetweenNotZeroPoints(){
        Point point1= new Point(2,3);
        Point point2=new Point(2,3);
        double distance=DistanceCalculator.calculateDistance(point1,point2);
        Assert.assertEquals(0.0,distance,0.00000001);
    }

    @Test
    public void calculateDistanceIsEqualFiveBetweenPositivePointAndOriginPoint(){
        Point point1= new Point(4,3);
        Point point2=new Point(0,0);
        double distance=DistanceCalculator.calculateDistance(point1,point2);
        Assert.assertEquals(5.0,distance,0.00000001);
    }

    @Test
    public void calculateDistanceIsEqualFiveBetweenNegativePointAndOriginPoint(){
        Point point1= new Point(-4,-3);
        Point point2=new Point(0,0);
        double distance=DistanceCalculator.calculateDistance(point1,point2);
        Assert.assertEquals(5.0,distance,0.00000001);
    }
}
