package com.goit.dlenchuk.controller;

import com.goit.dlenchuk.entity.Employee;
import com.goit.dlenchuk.entity.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ControllerOfReferences {

    private EmployeeDAO employee;

    public EmployeeDAO getEmployee() {
        return employee;
    }

    @Autowired
    public void setEmployee(EmployeeDAO employee) {
        this.employee = employee;
    }

    @RequestMapping("/")
    public String home(Model model, Principal principal) {
        return "index";
    }

    @RequestMapping("/employee")
    public String employee(Model model, Principal principal) {
        List<Employee> employees = employee.findAll();

        model.addAttribute("entries", employees);

        return "index";
    }

}
