package com.goit.dlenchuk.entity.dao.mysql;

import com.goit.dlenchuk.entity.Employee;
import com.goit.dlenchuk.entity.Position;
import com.goit.dlenchuk.entity.PositionOfEmployee;
import com.goit.dlenchuk.entity.dao.PositionOfEmployeeDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PositionOfEmployeeDAOMySqlImpl implements PositionOfEmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void appointAs(PositionOfEmployee positionOfEmployee) {

    }

    @Override
    public void dismiss(PositionOfEmployee positionOfEmployee) {

    }

    @Override
    public void setSalary(PositionOfEmployee positionOfEmployee, Integer salary) {

    }

    @Override
    public List<Position> findPositionsOfEmployee(Employee employee) {
        return null;
    }

}
