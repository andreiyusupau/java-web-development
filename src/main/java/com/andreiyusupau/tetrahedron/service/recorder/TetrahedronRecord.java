package com.andreiyusupau.tetrahedron.service.recorder;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.model.Tetrahedron;

import java.util.HashSet;
import java.util.Set;

public final class TetrahedronRecord implements Observable<TetrahedronRecord> {

    private final Tetrahedron tetrahedron;
    private final Set<Observer<TetrahedronRecord>> observers = new HashSet<>();
    private long id;
    private String name;

    public TetrahedronRecord(String name, Tetrahedron tetrahedron) {
        this.name = name;
        this.tetrahedron = tetrahedron;
    }

    public TetrahedronRecord(String name, Point pointA, Point pointB, Point pointC, Point pointD) {
        this.name = name;
        tetrahedron = new Tetrahedron(pointA, pointB, pointC, pointD);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Point getPointA() {
        return tetrahedron.getPointA();
    }

    public void setPointA(Point point) {
        if (!point.equals(tetrahedron.getPointA())) {
            tetrahedron.setPointA(point);
            notifyObservers();
        }
    }

    public Point getPointB() {
        return tetrahedron.getPointB();
    }

    public void setPointB(Point point) {
        if (!point.equals(tetrahedron.getPointB())) {
            tetrahedron.setPointB(point);
            notifyObservers();
        }
    }

    public Point getPointC() {
        return tetrahedron.getPointC();
    }

    public void setPointC(Point point) {
        if (!point.equals(tetrahedron.getPointC())) {
            tetrahedron.setPointC(point);
            notifyObservers();
        }
    }

    public Point getPointD() {
        return tetrahedron.getPointD();
    }

    public void setPointD(Point point) {
        if (!point.equals(tetrahedron.getPointD())) {
            tetrahedron.setPointD(point);
            notifyObservers();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.equals(this.name)) {
            this.name = name;
            notifyObservers();
        }
    }

    @Override
    public void addObserver(Observer<TetrahedronRecord> observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<TetrahedronRecord> observer : observers) {
            observer.update(this);
        }
    }
}
