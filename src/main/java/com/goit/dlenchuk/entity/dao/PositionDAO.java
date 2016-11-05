package com.goit.dlenchuk.entity.dao;

import com.goit.dlenchuk.entity.Employee;
import com.goit.dlenchuk.entity.Position;

import java.util.List;

public interface PositionDAO {

    void save(Position position);

    Position delete(Position position);

    List<Position> findByName(String name);

    List<Position> findAll();

}
