package com.goit.dlenchuk.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {

    private Integer ordId;
    private String ordNumber;
    private Integer ordTable;
    private Employee waiter;
    private Date ordDate;

    @Id
    @Column(name = "ORD_ID", nullable = false)
    @GeneratedValue
    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    @Column(name = "ORD_NUMBER", length = 25, nullable = false)
    public String getOrdNumber() {
        return ordNumber;
    }

    public void setOrdNumber(String ordNumber) {
        this.ordNumber = ordNumber;
    }

    @Column(name = "ORD_TABLE", nullable = false)
    public Integer getOrdTable() {
        return ordTable;
    }

    public void setOrdTable(Integer ordTable) {
        this.ordTable = ordTable;
    }

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "EMP_ID", nullable = false)
    public Employee getWaiter() {
        return waiter;
    }

    public void setWaiter(Employee waiter) {
        this.waiter = waiter;
    }

    @Column(name = "ORD_DATE", nullable = false)
    public Date getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(Date ordDate) {
        this.ordDate = ordDate;
    }
}
