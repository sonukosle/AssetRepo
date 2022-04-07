package com.asset.services.impl;

import com.asset.dto.EmployeeDto;
import com.asset.helper.UserFoundException;
import com.asset.model.Asset_raise_request;
import com.asset.model.Employee;
import com.asset.repo.Employee_Repo;
import com.asset.services.Employee_Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Employee_Service_Impl implements Employee_Service {

    @Autowired
    private Employee_Repo employee_repo;

    @Override
    public Employee createEmployee(Employee employee) throws UserFoundException {

        Employee employee_email = this.employee_repo.findByEmail(employee.getEmail());

        Employee e = null;

        if (employee_email != null) {

            System.out.println("Employee Already there !!");

            throw new UserFoundException();
        } else {

            e = this.employee_repo.save(employee);

//           e = modelMapper.map(employee, EmployeeDto.class);
        }

        return e;
    }


    //creating entity to dto

//    private EmployeeDto convertEntityToDto(Employee employee) {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmpId(employee.getEmpId());
//        employeeDto.setEmpName(employee.getEmpName());
//        employeeDto.setEmail(employee.getEmail());
//        employeeDto.setEmpAge(employee.getEmpAge());
//        employeeDto.setEmpDept(employee.getEmpDept());
//        employeeDto.setEmployee_address(employee.getEmployee_address());
//        employeeDto.setEmpJoiningDate(employee.getEmpJoiningDate());
//        employeeDto.setEmpDesignation(employee.getEmpDesignation());
//        employeeDto.setEmpPassword(employee.getEmpPassword());
//        employeeDto.setEmpRole(employee.getEmpRole());
//        employeeDto.setEmpFixedAnnualSalary(employee.getEmpFixedAnnualSalary());
//        Asset_raise_request asset_raise_request = new Asset_raise_request();
//        asset_raise_request.getAsset();
//        asset_raise_request.getAssetRaiseId();
//        asset_raise_request.getEmployee();
//        asset_raise_request.getAssetReqName();
//        asset_raise_request.getAssetTrack();
//        List<Asset_raise_request> list=new ArrayList<>();
//        list.add(asset_raise_request);
//        employeeDto.setAsset_raise_requests(list);
//        return employeeDto;
//
//    }


    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> all_employee = this.employee_repo.findAll();
        return all_employee;
    }
}
