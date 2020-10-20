package com.andreiyusupau.tetrahedron.repository.sort;

import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;

import java.util.Comparator;

public class IdComparator implements Comparator<TetrahedronRecord> {

    @Override
    public int compare(TetrahedronRecord firstTetrahedronRecord, TetrahedronRecord secondTetrahedronRecord) {
        long firstId = firstTetrahedronRecord.getId();
        long secondId = secondTetrahedronRecord.getId();
        return Long.compare(firstId, secondId);
    }
}
