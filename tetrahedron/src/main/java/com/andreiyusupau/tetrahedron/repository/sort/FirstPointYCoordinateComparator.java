package com.andreiyusupau.tetrahedron.repository.sort;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;

import java.util.Comparator;

public class FirstPointYCoordinateComparator implements Comparator<TetrahedronRecord> {

    @Override
    public int compare(TetrahedronRecord firstTetrahedronRecord, TetrahedronRecord secondTetrahedronRecord) {
        Point firstPointA = firstTetrahedronRecord.getPointA();
        Point secondPointA = secondTetrahedronRecord.getPointA();
        double firstPointACoordinateY = firstPointA.getY();
        double secondPointACoordinateY = secondPointA.getY();
        return Double.compare(firstPointACoordinateY, secondPointACoordinateY);
    }
}
