package com.asset.controller;

import com.asset.dto.EmployeeDto;
import com.asset.helper.UserFoundException;
import com.asset.model.Employee;
import com.asset.services.impl.Employee_Service_Impl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private Employee_Service_Impl employee_service_Impl;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping("/addemployee")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody Employee employee) throws UserFoundException {

//        EmployeeDto employee1 = this.employee_service_Impl.createEmployee(employee);

        EmployeeDto map = modelMapper.map(employee, EmployeeDto.class);
        return new ResponseEntity<EmployeeDto>(map, HttpStatus.CREATED);
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {

        List<Employee> allEmployee = this.employee_service_Impl.getAllEmployee();


        return ResponseEntity.ok(allEmployee);

    }


}
