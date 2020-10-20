package com.andreiyusupau.tetrahedron.repository.specification;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OctanteSpecificationTest {

    private OctanteSpecification specification;

    private Point pointA=new Point(7.0,2.0,3.0);
    private  Point pointB=new Point(1.0,2.0,2.0);
    private  Point pointC=new Point(6.0,2.0,5.0);
    private  Point pointD=new Point(1.0,4.0,4.0);
    private TetrahedronRecord tetrahedronRecord=new TetrahedronRecord("tetrahedronRecord",pointA,pointB,pointC,pointD);

    @Test
    void specifiedShouldReturnTrue(){
        specification=new OctanteSpecification(1);
        boolean specifiedResult= specification.specified(tetrahedronRecord);
        assertTrue(specifiedResult);
    }

    @Test
    void specifiedShouldReturnFalse(){
        specification=new OctanteSpecification(8);
        boolean specifiedResult= specification.specified(tetrahedronRecord);
        assertFalse(specifiedResult);
    }
}
