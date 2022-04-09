package com.asset.services;

import com.asset.helper.UserFoundException;
import com.asset.modal.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Employee_Service {

    // creating employee
    public Employee createEmployee(Employee employee) throws UserFoundException;

//    get all employee's

    public List<Employee> getAllEmployee();
}
