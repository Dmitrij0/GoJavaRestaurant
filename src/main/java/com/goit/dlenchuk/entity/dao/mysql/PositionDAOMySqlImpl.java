package com.goit.dlenchuk.entity.dao.mysql;

import com.goit.dlenchuk.entity.Position;
import com.goit.dlenchuk.entity.dao.PositionDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PositionDAOMySqlImpl implements PositionDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Position position) {
        entityManager.persist(position);
    }

    @Override
    public Position delete(Position position) {
        return null;
    }

    @Override
    public List<Position> findByName(String name) {
        return null;
    }

    @Override
    public List<Position> findAll() {
        return null;
    }
}
