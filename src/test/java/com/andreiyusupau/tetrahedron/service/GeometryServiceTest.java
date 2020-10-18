package com.andreiyusupau.tetrahedron.service;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.model.Tetrahedron;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GeometryServiceTest {

    private final GeometryService geometryService = new GeometryService();
    private final Point pointA = new Point(0, 0, 5);
    private final Point pointB = new Point(0, 0, -5);
    private final Point pointC = new Point(5, 0, 0);
    private final Point pointD = new Point(0, 5, 0);
    private final Tetrahedron tetrahedron = new Tetrahedron(pointA, pointB, pointC, pointD);
    private final Point pointE = new Point(1, 0, 0);
    private final Point pointF = new Point(1, 2, 0);
    private final Point pointG = new Point(1, 0, 2);

    @Test
    void calculateTetrahedronAreaShouldReturnNinetyThree() {
        double actualArea = geometryService.calculateTetrahedronArea(pointA, pointB, pointC, pointD);

        assertEquals(93.3012701892219, actualArea, 5 * Math.ulp(actualArea));
    }

    @Test
    void calculateTetrahedronVolumeShouldReturnFortyOne() {
        double actualVolume = geometryService.calculateTetrahedronVolume(pointA, pointB, pointC, pointD);

        assertEquals(41.66666666666666, actualVolume, 5 * Math.ulp(actualVolume));
    }

    @Test
    void isTetrahedron() {
        boolean isTetrahedron = geometryService.isTetrahedron(pointA, pointB, pointC, pointD);

        assertTrue(isTetrahedron);
    }

    @Test
    void calculateVolumeRatioAfterThePlaneSectionShouldReturn() {
        double volumeRatio = geometryService.calculateVolumeRatioAfterThePlaneSection(tetrahedron, pointE, pointF, pointG);

        assertEquals(1.049180327868853, volumeRatio, 5 * Math.ulp(volumeRatio));
    }

    @Test
    void isOneOfBasesOnTheCoordinatePlaneShouldReturnTrue() {
        boolean isOnOneOfTheCoordinatePlanes = geometryService.isOneOfBasesOnTheCoordinatePlane(tetrahedron);

        assertTrue(isOnOneOfTheCoordinatePlanes);
    }
}
