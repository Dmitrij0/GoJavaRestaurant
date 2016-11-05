package com.goit.dlenchuk.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "POSITIONS")
public class Position {

    private Integer pstId;
    private String pstName;
    private List<PositionOfEmployee> employees;

    @Id
    @GeneratedValue
    @Column(name = "PST_ID", nullable = false)
    public Integer getPstId() {
        return pstId;
    }

    public Position setPstId(Integer pstId) {
        this.pstId = pstId;
        return this;
    }

    @Column(name = "PST_NAME", nullable = false)
    public String getPstName() {
        return pstName;
    }

    public Position setPstName(String pstName) {
        this.pstName = pstName;
        return this;
    }

    @OneToMany(mappedBy = "position")
    public List<PositionOfEmployee> getEmployees() {
        return employees;
    }

    public Position setEmployees(List<PositionOfEmployee> employees) {
        this.employees = employees;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (!pstId.equals(position.pstId)) return false;
        return pstName.equals(position.pstName);

    }

    @Override
    public int hashCode() {
        int result = pstId.hashCode();
        result = 31 * result + pstName.hashCode();
        return result;
    }
}
