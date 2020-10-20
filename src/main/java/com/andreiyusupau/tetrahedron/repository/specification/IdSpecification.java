package com.andreiyusupau.tetrahedron.repository.specification;

import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;

public class IdSpecification implements Specification<TetrahedronRecord> {

    private final long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specified(TetrahedronRecord tetrahedronRecord) {
        long tetrahedronId = tetrahedronRecord.getId();
        return tetrahedronId == id;
    }
}
