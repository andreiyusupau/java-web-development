package com.andreiyusupau.tetrahedron.repository.specification;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.service.GeometryService;
import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;

public class AreaInRangeSpecification implements Specification<TetrahedronRecord> {
    private final double minArea;
    private final double maxArea;
    private final GeometryService geometryService;

    public AreaInRangeSpecification(double minArea, double maxArea, GeometryService geometryService) {
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.geometryService = geometryService;
    }

    @Override
    public boolean specified(TetrahedronRecord tetrahedronRecord) {
        if (minArea > maxArea) {
            return false;
        }
        Point pointA = tetrahedronRecord.getPointA();
        Point pointB = tetrahedronRecord.getPointB();
        Point pointC = tetrahedronRecord.getPointC();
        Point pointD = tetrahedronRecord.getPointD();
        double tetrahedronArea = geometryService.calculateTetrahedronArea(pointA, pointB, pointC, pointD);
        return tetrahedronArea > minArea && tetrahedronArea < maxArea;
    }
}
