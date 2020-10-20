package com.andreiyusupau.tetrahedron.repository;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.repository.specification.Specification;
import com.andreiyusupau.tetrahedron.repository.util.IdGenerator;
import com.andreiyusupau.tetrahedron.service.recorder.TetrahedronRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class TetrahedronRecordRepository implements Repository<TetrahedronRecord> {

    private static final Logger LOGGER = LogManager.getLogger(TetrahedronRecordRepository.class);

    private final List<TetrahedronRecord> tetrahedronRecords = new ArrayList<>();
    private final IdGenerator idGenerator;

    public TetrahedronRecordRepository(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public void add(TetrahedronRecord tetrahedronRecord) {
        LOGGER.info("New tetrahedron record has been added to repository.");
        long id = idGenerator.getNextId();
        tetrahedronRecord.setId(id);
        tetrahedronRecords.add(tetrahedronRecord);
    }

    @Override
    public void remove(TetrahedronRecord tetrahedronRecord) {
        LOGGER.info("Tetrahedron record has been removed from repository.");
        tetrahedronRecords.remove(tetrahedronRecord);
    }

    @Override
    public void update(TetrahedronRecord updatedTetrahedronRecord) {
        for (TetrahedronRecord tetrahedronRecord : tetrahedronRecords) {
            if (tetrahedronRecord.getId() == updatedTetrahedronRecord.getId()) {
                LOGGER.info("Tetrahedron record has been updated in repository.");
                Point updatedPointA = updatedTetrahedronRecord.getPointA();
                Point updatedPointB = updatedTetrahedronRecord.getPointB();
                Point updatedPointC = updatedTetrahedronRecord.getPointC();
                Point updatedPointD = updatedTetrahedronRecord.getPointD();
                tetrahedronRecord.setPointA(updatedPointA);
                tetrahedronRecord.setPointB(updatedPointB);
                tetrahedronRecord.setPointC(updatedPointC);
                tetrahedronRecord.setPointD(updatedPointD);
                break;
            }
        }
    }

    @Override
    public List<TetrahedronRecord> find(Specification<TetrahedronRecord> specification) {
        List<TetrahedronRecord> specifiedTetrahedronRecords = new ArrayList<>();
        for (TetrahedronRecord tetrahedronRecord : tetrahedronRecords) {
            if (specification.specified(tetrahedronRecord)) {
                specifiedTetrahedronRecords.add(tetrahedronRecord);
            }
        }
        return specifiedTetrahedronRecords;
    }

    @Override
    public List<TetrahedronRecord> find(Specification<TetrahedronRecord> specification, Comparator<TetrahedronRecord> comparator) {
        List<TetrahedronRecord> specifiedTetrahedronRecords = find(specification);
        specifiedTetrahedronRecords.sort(comparator);
        return specifiedTetrahedronRecords;
    }
}
