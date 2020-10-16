package com.andreiyusupau.tetrahedron.service;

import com.andreiyusupau.tetrahedron.model.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GeometryServiceTest {

    private final GeometryService geometryService = new GeometryService();

    @Test
    void testCalculateTetrahedronAreaShouldReturnNinetyThree() {
        Point pointA = new Point(0, 0, 5);
        Point pointB = new Point(0, 0, -5);
        Point pointC = new Point(5, 0, 0);
        Point pointD = new Point(0, 5, 0);

        double actualArea = geometryService.calculateTetrahedronArea(pointA, pointB, pointC, pointD);

        double expectedArea = 93.3012701892219;
        Assertions.assertEquals(expectedArea,actualArea,5*Math.ulp(actualArea));
    }

    @Test
    void testCalculateTetrahedronVolumeShouldReturnFortyOne(){
        Point pointA = new Point(0, 0, 5);
        Point pointB = new Point(0, 0, -5);
        Point pointC = new Point(5, 0, 0);
        Point pointD = new Point(0, 5, 0);

        double actualVolume= geometryService.calculateTetrahedronVolume(pointA, pointB, pointC, pointD);

        double expectedVolume = 41.66666666666666;
        Assertions.assertEquals(expectedVolume,actualVolume,5*Math.ulp(actualVolume));
    }

    @Test
    void testCalculateTetrahedronVolumeShouldReturn(){
        Point pointA = new Point(0, 0, 5);
        Point pointB = new Point(0, 0, -5);
        Point pointC = new Point(5, 0, 0);
        Point pointD = new Point(0, 5, 0);

        double actualVolume= geometryService.calculateTetrahedronVolume(pointA, pointB, pointC, pointD);

        double expectedVolume = 41.66666666666666;
        Assertions.assertEquals(expectedVolume,actualVolume,5*Math.ulp(actualVolume));
    }
}
