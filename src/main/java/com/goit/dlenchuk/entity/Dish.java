package com.goit.dlenchuk.entity;

import javax.persistence.*;

@Entity
@Table(name = "DISH")
public class Dish {

    private Integer dshId;
    private String dshName;
    private String dshCategory;
    private Integer dshWeight;

    @Id
    @GeneratedValue
    @Column(name = "DSH_ID", nullable = false)
    public Integer getDshId() {
        return dshId;
    }

    public void setDshId(Integer dshId) {
        this.dshId = dshId;
    }

    @Column(name = "DSH_NAME", nullable = false)
    public String getDshName() {
        return dshName;
    }

    public void setDshName(String dshName) {
        this.dshName = dshName;
    }

    @Column(name = "DSH_CATEGORY", nullable = false)
    public String getDshCategory() {
        return dshCategory;
    }

    public void setDshCategory(String dshCategory) {
        this.dshCategory = dshCategory;
    }

    @Column(name = "DSH_WEIGHT", nullable = false, scale = 5)
    public Integer getDshWeight() {
        return dshWeight;
    }

    public void setDshWeight(Integer dshWeight) {
        this.dshWeight = dshWeight;
    }
}
