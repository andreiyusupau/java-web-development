package com.andreiyusupau.tetrahedron.service.recorder;

import com.andreiyusupau.tetrahedron.model.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecorderTest {

    private final Recorder recorder = Recorder.getInstance();

    private Point pointA = new Point(7.0, 2.0, 3.0);
    private Point pointB = new Point(-1.0, 2.0, 2.0);
    private Point pointC = new Point(1.0, 2.0, -3.0);
    private Point pointD = new Point(1.0, -2.0, 4.0);
    private TetrahedronRecord tetrahedronRecord = new TetrahedronRecord("tetrahedronRecord", pointA, pointB, pointC, pointD);

    @Test
    void updateShouldAddNewRecordsToAreaAndVolumeMaps() {
        tetrahedronRecord.setId(1);

        int areaMapSizeBeforeUpdate = recorder.getAreaMap()
                .size();
        int volumeMapSizeBeforeUpdate = recorder.getVolumeMap()
                .size();
        assertEquals(0, areaMapSizeBeforeUpdate);
        assertEquals(0, volumeMapSizeBeforeUpdate);

        recorder.update(tetrahedronRecord);

        int areaMapSizeAfterUpdate = recorder.getAreaMap()
                .size();
        int volumeMapSizeAfterUpdate = recorder.getVolumeMap()
                .size();
        assertEquals(1, areaMapSizeAfterUpdate);
        assertEquals(1, volumeMapSizeAfterUpdate);
    }
}
