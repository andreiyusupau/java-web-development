package com.andreiyusupau.tetrahedron.repository.specification;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.service.GeometryService;
import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;

public class DistanceFromOriginInRangeSpecification implements Specification<TetrahedronRecord> {

    private final double minDistance;
    private final double maxDistance;
    private final GeometryService geometryService;

    public DistanceFromOriginInRangeSpecification(double minDistance, double maxDistance, GeometryService geometryService) {
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
        this.geometryService = geometryService;
    }

    @Override
    public boolean specified(TetrahedronRecord tetrahedronRecord) {
        if (minDistance > maxDistance) {
            return false;
        }
        Point pointA = tetrahedronRecord.getPointA();
        Point pointB = tetrahedronRecord.getPointB();
        Point pointC = tetrahedronRecord.getPointC();
        Point pointD = tetrahedronRecord.getPointD();
        double distanceAO = geometryService.calculateVectorModule(pointA);
        double distanceBO = geometryService.calculateVectorModule(pointB);
        double distanceCO = geometryService.calculateVectorModule(pointC);
        double distanceDO = geometryService.calculateVectorModule(pointD);
        return distanceAO > minDistance && distanceAO < maxDistance &&
                distanceBO > minDistance && distanceBO < maxDistance &&
                distanceCO > minDistance && distanceCO < maxDistance &&
                distanceDO > minDistance && distanceDO < maxDistance;
    }
}
