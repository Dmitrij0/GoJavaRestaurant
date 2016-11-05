package com.goit.dlenchuk.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROLE")
public class Role {

    private Integer rleId;
    private String rleName;
    private List<Employee> employees;

    @Id
    @GeneratedValue
    @Column(name = "RLE_ID", nullable = false)
    public Integer getRleId() {
        return rleId;
    }

    public void setRleId(Integer rleId) {
        this.rleId = rleId;
    }

    @Column(name = "RLE_NAME", length = 32, nullable = false, unique = true)
    public String getRleName() {
        return rleName;
    }

    public void setRleName(String rleName) {
        this.rleName = rleName;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return rleName;
    }
}
