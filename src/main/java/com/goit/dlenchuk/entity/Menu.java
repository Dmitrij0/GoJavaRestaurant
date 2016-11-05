package com.goit.dlenchuk.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MENU")
public class Menu {

    private Integer mnuId;
    private String mnuName;
    private List<Dish> Dishes;

    @Id
    @GeneratedValue
    @Column(name = "MNU_ID", nullable = false)
    public Integer getMnuId() {
        return mnuId;
    }

    public Menu setMnuId(Integer mnuId) {
        this.mnuId = mnuId;
        return this;
    }

    @Column(name = "MNU_NAME", nullable = false)
    public String getMnuName() {
        return mnuName;
    }

    public Menu setMnuName(String mnuName) {
        this.mnuName = mnuName;
        return this;
    }

    @ManyToMany
    @JoinTable(
            name = "DISHES_OF_MENU",
            joinColumns = @JoinColumn(name = "MNU_ID", referencedColumnName = "MNU_ID"),
            inverseJoinColumns = @JoinColumn(name = "DSH_ID", referencedColumnName = "DSH_ID")
    )
    public List<Dish> getDishes() {
        return Dishes;
    }

    public void setDishes(List<Dish> dishes) {
        Dishes = dishes;
    }
}
