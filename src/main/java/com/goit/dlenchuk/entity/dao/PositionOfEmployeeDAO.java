package com.goit.dlenchuk.entity.dao;

import com.goit.dlenchuk.entity.Employee;
import com.goit.dlenchuk.entity.Position;
import com.goit.dlenchuk.entity.PositionOfEmployee;

import java.util.List;

public interface PositionOfEmployeeDAO {

    void appointAs(PositionOfEmployee positionOfEmployee);

    void dismiss(PositionOfEmployee positionOfEmployee);

    void setSalary(PositionOfEmployee positionOfEmployee, Integer salary);

    List<Position> findPositionsOfEmployee(Employee employee);

}
