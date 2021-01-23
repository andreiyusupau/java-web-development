package com.andreiyusupau.tetrahedron.repository.sort;

import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdComparatorTest {
    private final IdComparator comparator=new IdComparator();

    @Test
    void compareShouldReturnOne(){
        TetrahedronRecord firstTetrahedronRecord=new TetrahedronRecord("firstTetrahedronRecord",null);
        firstTetrahedronRecord.setId(2);
        TetrahedronRecord secondTetrahedronRecord=new TetrahedronRecord("secondTetrahedronRecord",null);
        secondTetrahedronRecord.setId(1);
        int compareResult= comparator.compare(firstTetrahedronRecord,secondTetrahedronRecord);
        assertEquals(1,compareResult);
    }

    @Test
    void compareShouldReturnMinusOne(){
        TetrahedronRecord firstTetrahedronRecord=new TetrahedronRecord("firstTetrahedronRecord",null);
        firstTetrahedronRecord.setId(1);
        TetrahedronRecord secondTetrahedronRecord=new TetrahedronRecord("secondTetrahedronRecord",null);
        secondTetrahedronRecord.setId(3);
        int compareResult= comparator.compare(firstTetrahedronRecord,secondTetrahedronRecord);
        assertEquals(-1,compareResult);
    }

    @Test
    void compareShouldReturnZero(){
        TetrahedronRecord firstTetrahedronRecord=new TetrahedronRecord("firstTetrahedronRecord",null);
        firstTetrahedronRecord.setId(5);
        TetrahedronRecord secondTetrahedronRecord=new TetrahedronRecord("secondTetrahedronRecord",null);
        secondTetrahedronRecord.setId(5);
        int compareResult= comparator.compare(firstTetrahedronRecord,secondTetrahedronRecord);
        assertEquals(0,compareResult);
    }
}
