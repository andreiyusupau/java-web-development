package com.andreiyusupau.tetrahedron.model;

public final class Tetrahedron {

    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private final Point pointD;

    public Tetrahedron(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Tetrahedron that = (Tetrahedron) o;

        if (!pointA.equals(that.pointA)) return false;
        if (!pointB.equals(that.pointB)) return false;
        if (!pointC.equals(that.pointC)) return false;
        return pointD.equals(that.pointD);
    }

    @Override
    public int hashCode() {
        int result = pointA.hashCode();
        result = 31 * result + pointB.hashCode();
        result = 31 * result + pointC.hashCode();
        result = 31 * result + pointD.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tetrahedron{");
        sb.append("pointA=").append(pointA);
        sb.append(", pointB=").append(pointB);
        sb.append(", pointC=").append(pointC);
        sb.append(", pointD=").append(pointD);
        sb.append('}');
        return sb.toString();
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public Point getPointD() {
        return pointD;
    }
}
