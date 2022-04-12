package com.asset.controller;

import com.asset.dto.EmployeeCustomDetailsDto;
import com.asset.dto.EmployeeDto;
import com.asset.dto.EmployeeLoginDto;
import com.asset.helper.UserFoundException;
import com.asset.model.Employee;
import com.asset.services.Employee_Service;
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
    private Employee_Service employee_service;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping("/addemployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws UserFoundException {

//        EmployeeDto employee1 = this.employee_service_Impl.createEmployee(employee);

//        EmployeeDto map = modelMapper.map(employeeDto, EmployeeDto.class);
        Employee employee_Created = employee_service.createEmployee(employee);
        return new ResponseEntity<Employee>(employee_Created, HttpStatus.CREATED);
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        List<EmployeeDto> allEmployee = this.employee_service.getAllEmployee();
        return ResponseEntity.ok(allEmployee);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody EmployeeLoginDto employeeLoginDto) {

        try {
            this.employee_service.employeeLogin(employeeLoginDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body("Login Succeed !!");

    }

    @GetMapping("/customdata")
    public ResponseEntity<?> getCustomData() {

        List<EmployeeCustomDetailsDto> customDtaDto = this.employee_service.getCustomDtaDto();

        return ResponseEntity.ok(customDtaDto);
    }

}
