package com.andreiyusupau.tetrahedron.repository.specification;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;

public class OctanteSpecification implements Specification<TetrahedronRecord> {

    private final int octante;

    public OctanteSpecification(int octante) {
        this.octante = octante;
    }

    @Override
    public boolean specified(TetrahedronRecord tetrahedronRecord) {
        if (octante < 1 || octante > 8) {
            return false;
        }
        Point pointA = tetrahedronRecord.getPointA();
        Point pointB = tetrahedronRecord.getPointB();
        Point pointC = tetrahedronRecord.getPointC();
        Point pointD = tetrahedronRecord.getPointD();
        return inOctante(pointA, octante) &&
                inOctante(pointB, octante) &&
                inOctante(pointC, octante) &&
                inOctante(pointD, octante);
    }

    private boolean inOctante(Point point, int octante) {
        double x = point.getX();
        double y = point.getY();
        double z = point.getZ();
        switch (octante) {
            case 1:
                return x > 0 && y > 0 && z > 0;
            case 2:
                return x < 0 && y > 0 && z > 0;
            case 3:
                return x < 0 && y < 0 && z > 0;
            case 4:
                return x > 0 && y < 0 && z > 0;
            case 5:
                return x > 0 && y > 0 && z < 0;
            case 6:
                return x < 0 && y > 0 && z < 0;
            case 7:
                return x < 0 && y < 0 && z < 0;
            case 8:
                return x > 0 && y < 0 && z < 0;
            default:
                return false;
        }
    }
}
