package com.andreiyusupau.tetrahedron.repository;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.repository.specification.Specification;
import com.andreiyusupau.tetrahedron.repository.util.IdGenerator;
import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TetrahedronRecordRepositoryTest {

    @Mock
    private IdGenerator idGenerator;
    @InjectMocks
    private TetrahedronRecordRepository recordRepository;
    @Mock
    private Specification<TetrahedronRecord> specification;
    @Mock
    private Comparator<TetrahedronRecord> comparator;

    private Point firstPointA = new Point(7.0, 2.0, 3.0);
    private Point firstPointB = new Point(-1.0, 2.0, 2.0);
    private Point firstPointC = new Point(1.0, 2.0, -3.0);
    private Point firstPointD = new Point(1.0, -2.0, 4.0);
    private Point secondPointA = new Point(6.0, 2.0, 5.0);
    private Point secondPointB = new Point(1.0, 0.0, 3.0);
    private Point secondPointC = new Point(1.0, -7.0, 7.0);
    private Point secondPointD = new Point(4.0, 2.0, -3.0);
    private TetrahedronRecord firstTetrahedronRecord = new TetrahedronRecord("firstTetrahedronRecord", firstPointA, firstPointB, firstPointC, firstPointD);
    private TetrahedronRecord secondTetrahedronRecord = new TetrahedronRecord("secondTetrahedronRecord", secondPointA, secondPointB, secondPointC, secondPointD);

    @Test
    void addShouldCreateNewRecordWithId() {
        recordRepository.add(firstTetrahedronRecord);
        recordRepository.add(secondTetrahedronRecord);

        verify(idGenerator, times(2))
                .getNextId();
    }

    @Test
    void removeShouldNotThrowException() {
        recordRepository.remove(firstTetrahedronRecord);
    }

    @Test
    void updateShouldNotThrowException() {
        recordRepository.update(firstTetrahedronRecord);
    }

    @Test
    void findShouldReturnFirstTetrahedron() {
        when(specification.specified(firstTetrahedronRecord))
                .thenReturn(true);
        when(specification.specified(secondTetrahedronRecord))
                .thenReturn(false);
        recordRepository.add(firstTetrahedronRecord);
        recordRepository.add(secondTetrahedronRecord);

        List<TetrahedronRecord> specifiedList = recordRepository.find(specification);
        int listSize = specifiedList.size();
        assertEquals(1, listSize);
        List<TetrahedronRecord> expectedList = List.of(firstTetrahedronRecord);
        assertEquals(expectedList, specifiedList);
    }

    @Test
    void findShouldReturnSortedList() {
        when(specification.specified(any(TetrahedronRecord.class)))
                .thenReturn(true);
        when(comparator.compare(secondTetrahedronRecord,firstTetrahedronRecord))
                .thenReturn(-1);
        recordRepository.add(firstTetrahedronRecord);
        recordRepository.add(secondTetrahedronRecord);

        List<TetrahedronRecord> specifiedAndSortedList = recordRepository.find(specification, comparator);

        int listSize = specifiedAndSortedList.size();
        assertEquals(2, listSize);
        List<TetrahedronRecord> expectedList = List.of(secondTetrahedronRecord, firstTetrahedronRecord);
        assertEquals(expectedList, specifiedAndSortedList);
    }


}
