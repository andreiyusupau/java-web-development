package com.andreiyusupau.tetrahedron.repository.sort;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstPointXCoordinateComparatorTest {

    private final FirstPointXCoordinateComparator comparator=new FirstPointXCoordinateComparator();

    @Test
    void compareShouldReturnOne(){
        Point firstPointA=new Point(7.0,2.0,3.0);
        Point firstPointB=new Point(-1.0,2.0,2.0);
        Point firstPointC=new Point(1.0,2.0,-3.0);
        Point firstPointD=new Point(1.0,-2.0,4.0);
        Point secondPointA=new Point(6.0,2.0,5.0);
        Point secondPointB=new Point(1.0,0.0,3.0);
        Point secondPointC=new Point(1.0,-7.0,7.0);
        Point secondPointD=new Point(4.0,2.0,-3.0);
        TetrahedronRecord firstTetrahedronRecord=new TetrahedronRecord("firstTetrahedronRecord",firstPointA,firstPointB,firstPointC,firstPointD);
        TetrahedronRecord secondTetrahedronRecord=new TetrahedronRecord("secondTetrahedronRecord",secondPointA,secondPointB,secondPointC,secondPointD);
       int compareResult= comparator.compare(firstTetrahedronRecord,secondTetrahedronRecord);
       assertEquals(1,compareResult);
    }

    @Test
    void compareShouldReturnMinusOne(){
        Point firstPointA=new Point(1.0,2.0,3.0);
        Point firstPointB=new Point(-1.0,2.0,2.0);
        Point firstPointC=new Point(1.0,2.0,-3.0);
        Point firstPointD=new Point(1.0,-2.0,4.0);
        Point secondPointA=new Point(6.0,2.0,5.0);
        Point secondPointB=new Point(1.0,0.0,3.0);
        Point secondPointC=new Point(1.0,-7.0,7.0);
        Point secondPointD=new Point(4.0,2.0,-3.0);
        TetrahedronRecord firstTetrahedronRecord=new TetrahedronRecord("firstTetrahedronRecord",firstPointA,firstPointB,firstPointC,firstPointD);
        TetrahedronRecord secondTetrahedronRecord=new TetrahedronRecord("secondTetrahedronRecord",secondPointA,secondPointB,secondPointC,secondPointD);
        int compareResult= comparator.compare(firstTetrahedronRecord,secondTetrahedronRecord);
        assertEquals(-1,compareResult);
    }

    @Test
    void compareShouldReturnZero(){
        Point firstPointA=new Point(6.0,2.0,3.0);
        Point firstPointB=new Point(-1.0,2.0,2.0);
        Point firstPointC=new Point(1.0,2.0,-3.0);
        Point firstPointD=new Point(1.0,-2.0,4.0);
        Point secondPointA=new Point(6.0,2.0,5.0);
        Point secondPointB=new Point(1.0,0.0,3.0);
        Point secondPointC=new Point(1.0,-7.0,7.0);
        Point secondPointD=new Point(4.0,2.0,-3.0);
        TetrahedronRecord firstTetrahedronRecord=new TetrahedronRecord("firstTetrahedronRecord",firstPointA,firstPointB,firstPointC,firstPointD);
        TetrahedronRecord secondTetrahedronRecord=new TetrahedronRecord("secondTetrahedronRecord",secondPointA,secondPointB,secondPointC,secondPointD);
        int compareResult= comparator.compare(firstTetrahedronRecord,secondTetrahedronRecord);
        assertEquals(0,compareResult);
    }
}
