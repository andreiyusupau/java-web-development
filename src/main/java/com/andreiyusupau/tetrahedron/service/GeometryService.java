package com.andreiyusupau.tetrahedron.service;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.model.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class GeometryService {

    private static final Logger LOGGER = LogManager.getLogger(GeometryService.class);

    private Point calculateVector(Point a, Point b) {
        LOGGER.info("Calculate vector from two points");
        double x = b.getX() - a.getX();
        double y = b.getY() - a.getY();
        double z = b.getZ() - a.getZ();
        return new Point(x, y, z);
    }

    private Point calculateCrossProduct(Point a, Point b) {
        LOGGER.info("Calculate cross product of two vectors");
        double x = a.getY() * b.getZ() - a.getZ() * b.getY();
        double y = a.getZ() * b.getX() - a.getX() * b.getZ();
        double z = a.getX() * b.getY() - a.getY() * b.getX();
        return new Point(x, y, z);
    }

    public double calculateVectorModule(Point a) {
        LOGGER.info("Calculate vector module");
        return Math.sqrt(Math.pow(a.getX(), 2) + Math.pow(a.getY(), 2) + Math.pow(a.getZ(), 2));
    }

    private double calculateTriangleArea(Point a, Point b, Point c) {
        LOGGER.info("Calculate triangle area");
        Point vectorAB = calculateVector(a, b);
        Point vectorAC = calculateVector(a, c);
        Point vectorCrossProduct = calculateCrossProduct(vectorAB, vectorAC);
        double vectorModule = calculateVectorModule(vectorCrossProduct);
        return 0.5 * vectorModule;
    }

    public double calculateTetrahedronArea(Point a, Point b, Point c, Point d) {
        LOGGER.info("Calculate tetrahedron area.");
        double abcArea = calculateTriangleArea(a, b, c);
        double bcdArea = calculateTriangleArea(b, c, d);
        double cdaArea = calculateTriangleArea(c, d, a);
        double dabArea = calculateTriangleArea(d, a, b);
        return abcArea + bcdArea + cdaArea + dabArea;
    }

    private double calculateTripleProduct(Point row1, Point row2, Point row3) {
        LOGGER.info("Calculate vector triple product");
        return row1.getX() * row2.getY() * row3.getZ() +
                row1.getZ() * row2.getX() * row3.getY() +
                row1.getY() * row2.getZ() * row3.getX() -
                row1.getZ() * row2.getY() * row3.getX() -
                row1.getX() * row2.getZ() * row3.getY() -
                row1.getY() * row2.getX() * row3.getZ();
    }

    public double calculateTetrahedronVolume(Point a, Point b, Point c, Point d) {
        LOGGER.info("Calculate tetrahedron volume");
        Point vectorAB = calculateVector(a, b);
        Point vectorAC = calculateVector(a, c);
        Point vectorAD = calculateVector(a, d);
        double tripleProduct = calculateTripleProduct(vectorAB, vectorAC, vectorAD);
        return Math.abs(tripleProduct) / 6;
    }

    private double dotProduct(Point a, Point b) {
        LOGGER.info("Calculate vector dot product");
        return a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
    }

    private Point scale(Point a, double scale) {
        LOGGER.info("Scale vector");
        double x = a.getX() * scale;
        double y = a.getY() * scale;
        double z = a.getZ() * scale;
        return new Point(x, y, z);
    }

    private Point sum(Point a, Point b) {
        LOGGER.info("Calculate sum of two vectors");
        double x = a.getX() + b.getX();
        double y = a.getY() + b.getY();
        double z = a.getZ() + b.getZ();
        return new Point(x, y, z);
    }

    /**
     * @param a first point on the plane
     * @param b second point on the plane
     * @param c third point on the plane
     * @param x first point of line segment
     * @param y second point of line segment
     * @return intersection Point if line and point intersects
     */
    private Optional<Point> calculateIntersectionPointOfPlaneAndLine(Point a, Point b, Point c, Point x, Point y) {
        LOGGER.info("Calculate intersection point of plane and line");
        //TODO:normal vector direction
        Point normal = calculatePlaneNormal(a, b, c);
        Point vectorAD = calculateVector(a, x);
        double d = -dotProduct(normal, vectorAD);
        if (compareDouble(d, 0)) {
            LOGGER.warn("Line lays on the plane.");
            return Optional.empty();
        }
        Point vectorDE = calculateVector(x, y);
        double e = dotProduct(normal, vectorDE);
        if (!compareDouble(e, 0)) {
            LOGGER.info("Intersection point found.");
            double sI = d / e;
            Point scaledDE = scale(vectorDE, sI);
            Point intersectionPoint = sum(x, scaledDE);
            return Optional.of(intersectionPoint);
        } else {
            LOGGER.info("Line intersects plane, but line segment doesn't.");
            return Optional.empty();
        }
    }

    private Point calculatePlaneNormal(Point a, Point b, Point c) {
        LOGGER.info("Calculate plane normal");
        Point vectorAB = calculateVector(a, b);
        Point vectorAC = calculateVector(a, c);
        return calculateCrossProduct(vectorAB, vectorAC);
    }

    /**
     * Calculates the volume ratio of two parts of tetrahedron divided by plane
     *
     * @param tetrahedron tetrahedron
     * @param e           plane point E
     * @param f           plane point F
     * @param g           plane point G
     * @return partVolume/full volume
     */
    public double calculateVolumeRatioAfterThePlaneSection(Tetrahedron tetrahedron, Point e, Point f, Point g) {
        LOGGER.info("Calculate volume ratio of two parts of the tetrahedron after plane section.");
        Point a = tetrahedron.getPointA();
        Point b = tetrahedron.getPointB();
        Point c = tetrahedron.getPointC();
        Point d = tetrahedron.getPointD();
        Optional<Point> abi = calculateIntersectionPointOfPlaneAndLine(e, f, g, a, b);
        Optional<Point> aci = calculateIntersectionPointOfPlaneAndLine(e, f, g, a, c);
        Optional<Point> adi = calculateIntersectionPointOfPlaneAndLine(e, f, g, a, d);
        Optional<Point> bci = calculateIntersectionPointOfPlaneAndLine(e, f, g, b, c);
        Optional<Point> bdi = calculateIntersectionPointOfPlaneAndLine(e, f, g, b, d);
        Optional<Point> cdi = calculateIntersectionPointOfPlaneAndLine(e, f, g, c, d);
        double fullVolume = calculateTetrahedronVolume(a, b, c, d);
        double partVolume;
        if (abi.isPresent() && aci.isPresent() && adi.isPresent()) {
            LOGGER.info("Plane intersects edges AB, AC, AD.");
            partVolume = calculateTetrahedronVolume(a, abi.get(), aci.get(), adi.get());
        } else if (abi.isEmpty() && aci.isEmpty() && adi.isEmpty()) {
            LOGGER.info("Plane doesn't intersect tetrahedron.");
            partVolume = 0;
        } else if (aci.isEmpty() && adi.isEmpty()) {
            LOGGER.info("Plane intersects edges AB, BC, BD");
            partVolume = calculateTetrahedronVolume(b, abi.get(), bci.get(), bdi.get());
        } else if (abi.isEmpty() && adi.isEmpty()) {
            LOGGER.info("Plane intersects edges AC, BC, CD");
            partVolume = calculateTetrahedronVolume(c, aci.get(), bci.get(), cdi.get());
        } else if (abi.isEmpty() && aci.isEmpty()) {
            LOGGER.info("Plane intersects edges AD, DB,CD");
            partVolume = calculateTetrahedronVolume(d, adi.get(), bdi.get(), cdi.get());
        } else if (abi.isPresent() & aci.isPresent()) {
            LOGGER.info("Plane intersects edges AB, AC, BD, CD.");
            partVolume = calculateTetrahedronVolume(b, abi.get(), cdi.get(), bdi.get()) +
                    calculateTetrahedronVolume(b, abi.get(), aci.get(), cdi.get()) +
                    calculateTetrahedronVolume(b, c, aci.get(), cdi.get());
        } else if (abi.isPresent() & aci.isEmpty()) {
            LOGGER.info("Plane intersects edges AB, AD, BC, CD.");
            partVolume = calculateTetrahedronVolume(b, abi.get(), bci.get(), cdi.get()) +
                    calculateTetrahedronVolume(b, abi.get(), adi.get(), cdi.get()) +
                    calculateTetrahedronVolume(b, d, adi.get(), cdi.get());
        } else {
            LOGGER.info("Plane intersects edges AC, AD,  BC, BD.");
            partVolume = calculateTetrahedronVolume(c, aci.get(), bci.get(), bdi.get()) +
                    calculateTetrahedronVolume(c, aci.get(), adi.get(), bdi.get()) +
                    calculateTetrahedronVolume(c, d, adi.get(), bdi.get());
        }
        return partVolume / (fullVolume - partVolume);
    }

    public boolean isTetrahedron(Point a, Point b, Point c, Point d) {
        LOGGER.info("Check if four points form tetrahedron.");
        Point vectorAB = calculateVector(a, b);
        Point vectorAC = calculateVector(a, c);
        Point vectorCrossProduct = calculateCrossProduct(vectorAB, vectorAC);
        Point vectorAD = calculateVector(a, d);
        double distance = dotProduct(vectorCrossProduct, vectorAD);
        return !compareDouble(distance, 0.0);
    }

    public boolean isOneOfBasesOnTheCoordinatePlane(Tetrahedron tetrahedron) {
        LOGGER.info("Check if one of the tetrahedron bases lay on the coordinate plane.");
        Point pointA = tetrahedron.getPointA();
        Point pointB = tetrahedron.getPointB();
        Point pointC = tetrahedron.getPointC();
        Point pointD = tetrahedron.getPointD();
        if (isOnXPlane(pointA) + isOnXPlane(pointB) + isOnXPlane(pointC) + isOnXPlane(pointD) == 3) {
            return true;
        } else if (isOnYPlane(pointA) + isOnYPlane(pointB) + isOnYPlane(pointC) + isOnYPlane(pointD) == 3) {
            return true;
        } else {
            return isOnZPlane(pointA) + isOnZPlane(pointB) + isOnZPlane(pointC) + isOnZPlane(pointD) == 3;
        }
    }

    private int isOnXPlane(Point point) {
        return compareDouble(point.getX(), 0.0) ? 1 : 0;
    }

    private int isOnYPlane(Point point) {
        return compareDouble(point.getY(), 0.0) ? 1 : 0;
    }

    private int isOnZPlane(Point point) {
        return compareDouble(point.getZ(), 0.0) ? 1 : 0;
    }

    private boolean compareDouble(double a, double b) {
        return Math.abs(a - b) < Math.ulp(a);
    }

}
