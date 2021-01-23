package com.andreiyusupau.tetrahedron.repository.specification;

import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;

public class NameSpecification implements Specification<TetrahedronRecord> {

    private final String name;

    public NameSpecification(String name) {
        this.name = name;
    }

    @Override
    public boolean specified(TetrahedronRecord tetrahedronRecord) {
        String tetrahedronName = tetrahedronRecord.getName();
        return tetrahedronName.equals(name);
    }
}
