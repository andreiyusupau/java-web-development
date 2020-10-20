package com.andreiyusupau.tetrahedron.repository.sort;

import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NameComparatorTest {

    private final NameComparator comparator=new NameComparator();

    @Test
    void compareShouldReturnOne(){
        TetrahedronRecord firstTetrahedronRecord=new TetrahedronRecord("firstTetrahedronRecord",null);
        TetrahedronRecord secondTetrahedronRecord=new TetrahedronRecord("1secondTetrahedronRecord",null);
        int compareResult= comparator.compare(firstTetrahedronRecord,secondTetrahedronRecord);
        assertTrue(compareResult>0);
    }

    @Test
    void compareShouldReturnMinusOne(){
        TetrahedronRecord firstTetrahedronRecord=new TetrahedronRecord("firstTetrahedronRecord",null);
        TetrahedronRecord secondTetrahedronRecord=new TetrahedronRecord("secondTetrahedronRecord",null);
        int compareResult= comparator.compare(firstTetrahedronRecord,secondTetrahedronRecord);
        assertTrue(compareResult<0);
    }

    @Test
    void compareShouldReturnZero(){
        TetrahedronRecord firstTetrahedronRecord=new TetrahedronRecord("firstTetrahedronRecord",null);
        TetrahedronRecord secondTetrahedronRecord=new TetrahedronRecord("firstTetrahedronRecord",null);
        int compareResult= comparator.compare(firstTetrahedronRecord,secondTetrahedronRecord);
        assertEquals(0,compareResult);
    }
}
