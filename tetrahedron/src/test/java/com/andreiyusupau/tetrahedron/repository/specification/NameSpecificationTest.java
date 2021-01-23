package com.andreiyusupau.tetrahedron.repository.specification;

import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NameSpecificationTest {

    private final NameSpecification specification=new NameSpecification("name");

    private TetrahedronRecord tetrahedronRecord;

    @Test
    void specifiedShouldReturnTrue(){
        tetrahedronRecord=new TetrahedronRecord("name",null);
        boolean specifiedResult= specification.specified(tetrahedronRecord);
        assertTrue(specifiedResult);
    }

    @Test
    void specifiedShouldReturnFalse(){
        tetrahedronRecord=new TetrahedronRecord("notAName",null);
        boolean specifiedResult= specification.specified(tetrahedronRecord);
        assertFalse(specifiedResult);
    }
}
