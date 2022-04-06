package com.asset.controller;

import com.asset.helper.UserFoundException;
import com.asset.modal.Employee;
import com.asset.services.impl.Employee_Service_Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private Employee_Service_Impl employee_service_Impl;

    @PostMapping("addemployee")
    public Employee addEmployee(@RequestBody Employee employee) throws UserFoundException {

        Employee employee1 = this.employee_service_Impl.createEmployee(employee);
        return employee1;
    }
}
