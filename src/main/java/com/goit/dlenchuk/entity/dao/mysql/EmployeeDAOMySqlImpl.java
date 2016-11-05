package com.goit.dlenchuk.entity.dao.mysql;

import com.goit.dlenchuk.entity.Employee;
import com.goit.dlenchuk.entity.dao.EmployeeDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmployeeDAOMySqlImpl implements EmployeeDAO {

       @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee delete(Employee employee) {
        entityManager.detach(employee);
        return employee;
    }

    @Override
    public List<Employee> findByName(String name) {
        return entityManager
                .createQuery(
                        "select e " +
                                "from Employee e " +
                                "where e.empFirstName like :name " +
                                "or e.empLastName like :name " +
                                "or e.empLastName || ' ' || e.empFirstName like :name " +
                                "or e.empFirstName || ' ' || e.empLastName like :name " +
                                "order by e.empLastName, e.empFirstName, e.empBirthday", Employee.class)
                .setParameter("name", '%' + name.replaceAll("\\s+", "%") + '%')
                .getResultList();
    }

    @Override
    public Employee findByNickName(String nickname) {
        return entityManager
                .createQuery(
                        "select e " +
                                "from Employee e " +
                                "where e.empNickName = :nickname ", Employee.class)
                .setParameter("nickname", nickname).getSingleResult();
    }

    @Override
    public List<Employee> findAll() {
        return entityManager
                .createQuery(
                        "select e " +
                                "from Employee e " +
                                "order by e.empLastName, e.empFirstName, e.empBirthday", Employee.class)
                .getResultList();
    }

}
