package com.andreiyusupau.tetrahedron.repository.sort;

import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;

import java.util.Comparator;

public class NameComparator implements Comparator<TetrahedronRecord> {

    @Override
    public int compare(TetrahedronRecord firstTetrahedronRecord, TetrahedronRecord secondTetrahedronRecord) {
        String firstName = firstTetrahedronRecord.getName();
        String secondName = secondTetrahedronRecord.getName();
        return firstName.compareTo(secondName);
    }
}
