package com.goit.dlenchuk.entity.dao;

import com.goit.dlenchuk.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    void save(Employee employee);

    Employee delete(Employee employee);

    List<Employee> findByName(String name);

    Employee findByNickName(String nickname);

    List<Employee> findAll();

}
