package com.andreiyusupau.tetrahedron.repository.specification;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.service.GeometryService;
import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AreaInRangeSpecificationTest {

private GeometryService geometryService;
    private AreaInRangeSpecification specification;

    private Point pointA=new Point(7.0,2.0,3.0);
    private  Point pointB=new Point(-1.0,2.0,2.0);
    private  Point pointC=new Point(1.0,2.0,-3.0);
    private  Point pointD=new Point(1.0,-2.0,4.0);
    private TetrahedronRecord tetrahedronRecord=new TetrahedronRecord("tetrahedronRecord",pointA,pointB,pointC,pointD);

    @BeforeEach
    void set(){
        geometryService= Mockito.mock(GeometryService.class);
        specification=new AreaInRangeSpecification(1,100,geometryService);
    }

    @Test
    void specifiedShouldReturnTrue(){
        when(geometryService.calculateTetrahedronArea(any(Point.class),any(Point.class),any(Point.class),any(Point.class)))
                .thenReturn(99.0);
       boolean specifiedResult= specification.specified(tetrahedronRecord);
       assertTrue(specifiedResult);
    }

@Test
    void specifiedShouldReturnFalse(){
    when(geometryService.calculateTetrahedronArea(any(Point.class),any(Point.class),any(Point.class),any(Point.class)))
            .thenReturn(110.0);
    boolean specifiedResult= specification.specified(tetrahedronRecord);
    assertFalse(specifiedResult);
    }
}
