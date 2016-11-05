package com.goit.dlenchuk.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "POSITION_OF_EMPLOYEE")
public class PositionOfEmployee implements Serializable {

    private Employee employee;
    private Position position;
    private Integer poeSalary;

    @Id
    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    public Employee getEmployee() {
        return employee;
    }

    public PositionOfEmployee setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "PST_ID")
    public Position getPosition() {
        return position;
    }

    public PositionOfEmployee setPosition(Position position) {
        this.position = position;
        return this;
    }

    @Column(name = "POE_SALARY", nullable = false)
    public Integer getPoeSalary() {
        return poeSalary;
    }

    public PositionOfEmployee setPoeSalary(Integer poeSalary) {
        this.poeSalary = poeSalary;
        return this;
    }
}
