package com.asset.services.impl;

import com.asset.helper.UserFoundException;
import com.asset.modal.Employee;
import com.asset.repo.Employee_Repo;
import com.asset.services.Employee_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Employee_Service_Impl implements Employee_Service {

    @Autowired
    private Employee_Repo employee_repo;

    @Override
    public Employee createEmployee(Employee employee) throws UserFoundException {
        Employee employee1 = this.employee_repo.findByemp_email(employee.getEmp_email());

        if (employee1 != null) {

            System.out.println("Employee Already there !!");

            throw new UserFoundException();
        } else {

            Employee saved_employee = this.employee_repo.save(employee);
        }
        return employee1;
    }


    @Override
    public List<Employee> getAllEmployee() {

        List<Employee> all_employee = this.employee_repo.findAll();
        return all_employee;
    }
}
