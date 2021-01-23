package com.andreiyusupau.tetrahedron.service.recorder;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.service.GeometryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public final class Recorder implements Observer<TetrahedronRecord> {

    private static final Logger LOGGER = LogManager.getLogger(Recorder.class);

    private static final Recorder INSTANCE = new Recorder();
    private final GeometryService geometryService = new GeometryService();
    private final Map<Long, Double> areaMap = new HashMap<>();
    private final Map<Long, Double> volumeMap = new HashMap<>();

    private Recorder() {
        //prevent access with reflection
        if (INSTANCE != null) {
            throw new AssertionError();
        }
    }

    public static Recorder getInstance() {
        return INSTANCE;
    }

    @Override
    public void update(TetrahedronRecord tetrahedronRecord) {
        LOGGER.info("Observable updated.");
        long id = tetrahedronRecord.getId();
        Point pointA = tetrahedronRecord.getPointA();
        Point pointB = tetrahedronRecord.getPointB();
        Point pointC = tetrahedronRecord.getPointC();
        Point pointD = tetrahedronRecord.getPointD();
        double tetrahedronArea = geometryService.calculateTetrahedronArea(pointA, pointB, pointC, pointD);
        double tetrahedronVolume = geometryService.calculateTetrahedronVolume(pointA, pointB, pointC, pointD);
        areaMap.put(id, tetrahedronArea);
        volumeMap.put(id, tetrahedronVolume);
    }

    @Override
    public void setObservable(Observable<TetrahedronRecord> observable) {
        LOGGER.info("New observable added.");
        observable.addObserver(this);
    }

    public Map<Long, Double> getAreaMap() {
        return areaMap;
    }

    public Map<Long, Double> getVolumeMap() {
        return volumeMap;
    }
}
