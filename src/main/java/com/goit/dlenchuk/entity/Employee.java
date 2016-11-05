package com.goit.dlenchuk.entity;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    private Integer empId;
    private String empLastName;
    private String empFirstName;
    private String empNickName;
    private String empPassword;
    private Date empBirthday;
    private String empPhone;
    private List<PositionOfEmployee> positions;
    private List<Role> roles;

    @Id
    @GeneratedValue
    @Column(name = "EMP_ID", nullable = false)
    public Integer getEmpId() {
        return empId;
    }

    public Employee setEmpId(Integer empId) {
        this.empId = empId;
        return this;
    }

    @Column(name = "EMP_LAST_NAME", length = 50, nullable = false)
    public String getEmpLastName() {
        return empLastName;
    }

    public Employee setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
        return this;
    }

    @Column(name = "EMP_FIRST_NAME", length = 50, nullable = false)
    public String getEmpFirstName() {
        return empFirstName;
    }

    public Employee setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
        return this;
    }

    @Column(name = "EMP_NICKNAME", length = 10, nullable = false, unique = true)
    public String getEmpNickName() {
        return empNickName;
    }

    public Employee setEmpNickName(String empNickName) {
        this.empNickName = empNickName;
        return this;
    }

    @Column(name = "EMP_PASSWORD", length = 10, nullable = false)
    public String getEmpPassword() {

        return  empPassword;
    }

    public Employee setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
        return this;
    }

    @Column(name = "EMP_BIRTHDAY", nullable = false)
    public Date getEmpBirthday() {
        return empBirthday;
    }

    public Employee setEmpBirthday(Date empBirthday) {
        this.empBirthday = empBirthday;
        return this;
    }

    @Column(name = "EMP_PHONE", nullable = false)
    @Pattern(regexp = "^\\+38\\(0\\d{2}\\)\\d{3}-\\d{2}-\\d{2}$")
    public String getEmpPhone() {
        return empPhone;
    }

    public Employee setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
        return this;
    }

    @OneToMany(mappedBy = "employee")
    public List<PositionOfEmployee> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionOfEmployee> positions) {
        this.positions = positions;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ROLE_OF_EMPLOYEE",
            joinColumns = @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID"),
            inverseJoinColumns = @JoinColumn(name = "RLE_ID", referencedColumnName = "RLE_ID")
    )
    public List<Role> getRoles() {
        return roles;
    }

    public Employee setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!empId.equals(employee.empId)) return false;
        if (!empLastName.equals(employee.empLastName)) return false;
        if (!empFirstName.equals(employee.empFirstName)) return false;
        if (!empBirthday.equals(employee.empBirthday)) return false;
        return empPhone.equals(employee.empPhone);

    }

    @Override
    public int hashCode() {
        int result = empId.hashCode();
        result = 31 * result + empLastName.hashCode();
        result = 31 * result + empFirstName.hashCode();
        result = 31 * result + empBirthday.hashCode();
        result = 31 * result + empPhone.hashCode();
        return result;
    }
}
