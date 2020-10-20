package com.andreiyusupau.tetrahedron.repository.sort;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;

import java.util.Comparator;

public class FirstPointXCoordinateComparator implements Comparator<TetrahedronRecord> {

    @Override
    public int compare(TetrahedronRecord firstTetrahedronRecord, TetrahedronRecord secondTetrahedronRecord) {
        Point firstPointA = firstTetrahedronRecord.getPointA();
        Point secondPointA = secondTetrahedronRecord.getPointA();
        double firstPointACoordinateX = firstPointA.getX();
        double secondPointACoordinateX = secondPointA.getX();
        return Double.compare(firstPointACoordinateX, secondPointACoordinateX);
    }
}
