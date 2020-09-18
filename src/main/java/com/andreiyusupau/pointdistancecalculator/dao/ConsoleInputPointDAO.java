package com.andreiyusupau.pointdistancecalculator.dao;

import com.andreiyusupau.pointdistancecalculator.model.Point;
import com.andreiyusupau.pointdistancecalculator.util.PointReader;

public class ConsoleInputPointDAO implements DAO<Point> {
    private final PointReader pointReader;

    public ConsoleInputPointDAO(PointReader pointReader) {
        this.pointReader = pointReader;
    }

    @Override
    public Point get() {

        int x = pointReader.getCoordinate("x");
        int y = pointReader.getCoordinate("y");
        return new Point(x, y);
    }
}
