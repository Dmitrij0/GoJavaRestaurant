package com.goit.dlenchuk.service;

import com.goit.dlenchuk.entity.Employee;
import com.goit.dlenchuk.entity.Role;
import com.goit.dlenchuk.entity.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService implements UserDetailsService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public UserService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Employee employee = employeeDAO.findByNickName(username);

        if (employee != null) {
            List<Role> roleList = employee.getRoles();
            String[] roles = new String[roleList.size()];
            int counter = 0;
            for (Role role : roleList) {
                roles[counter++] = role.getRleName();
            }
            return new User(employee.getEmpNickName(), employee.getEmpPassword(),
                    AuthorityUtils.createAuthorityList(roles));
        }

        return null;
    }

}
