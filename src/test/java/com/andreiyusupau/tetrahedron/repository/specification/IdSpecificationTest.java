package com.andreiyusupau.tetrahedron.repository.specification;

import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IdSpecificationTest {

    private final IdSpecification specification=new IdSpecification(3);

    private TetrahedronRecord tetrahedronRecord;

    @BeforeEach
void set(){
        tetrahedronRecord=new TetrahedronRecord("name",null);
    }

    @Test
    void specifiedShouldReturnTrue(){
        tetrahedronRecord.setId(3);
        boolean specifiedResult= specification.specified(tetrahedronRecord);
        assertTrue(specifiedResult);
    }

    @Test
    void specifiedShouldReturnFalse(){
        tetrahedronRecord.setId(5);
        boolean specifiedResult= specification.specified(tetrahedronRecord);
        assertFalse(specifiedResult);
    }
}
