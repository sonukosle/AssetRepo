package com.asset.services.impl;

import com.asset.dto.EmployeeCustomDetailsDto;
import com.asset.dto.EmployeeDto;
import com.asset.dto.EmployeeLoginDto;
import com.asset.helper.UserFoundException;
import com.asset.model.Employee;
import com.asset.repo.Employee_Repo;
import com.asset.services.Employee_Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Employee_Service_Impl implements Employee_Service {

    @Autowired
    private Employee_Repo employee_repo;
    @Autowired
    public ModelMapper modelMapper;

    @Override
    public Employee createEmployee(Employee employee) throws UserFoundException {

        Employee employee_email = this.employee_repo.findByEmail(employee.getEmail());

        Employee e = null;

        if (employee_email != null) {

            System.out.println("Employee Already there !!");

            throw new UserFoundException();
        } else {
//            Employee employeeMap = modelMapper.map(, Employee.class);
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

    private EmployeeDto convertEntityToDto(Employee employee) {

//        modelMapper.getConfiguration()
//                .setMatchingStrategy(MatchingStrategies.LOOSE);
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }


    @Override
    public List<EmployeeDto> getAllEmployee() {
        return this.employee_repo.findAll()
                .stream()
                .map(this::convertEntityToDto).collect(Collectors.toList());

    }

    private EmployeeLoginDto convertEntityToDtoLogin(Employee employee) {

//        modelMapper.getConfiguration()
//                .setMatchingStrategy(MatchingStrategies.LOOSE);
        EmployeeLoginDto employeeLoginDto = new EmployeeLoginDto();
        employeeLoginDto = modelMapper.map(employee, EmployeeLoginDto.class);
        return employeeLoginDto;
    }


    @Override
    public EmployeeLoginDto employeeLogin(EmployeeLoginDto employeeLoginDto) {

        Employee employee= this.employee_repo.findByEmail(employeeLoginDto.getEmail());
////        String email = null;
//
//        List<Employee> all = this.employee_repo.getAll();
//       all.forEach(e->{
//           System.out.println(e);
//       });

//        Employee employeeE = this.employee_repo.findByEmail(employee.getEmail());

//        Optional<Employee> employeecheck = Optional.of(employee);

//        for (Employee e : byEmail
//        ) {
//            email = e.getEmail();
//        }

        if (employee.getEmail() == employeeLoginDto.getEmail()) {

            System.out.println("Record matched");
//            Optional.of("Record not matched!!");

        } else {

//            Optional.of("Successfully login");
            System.out.println("Record not matched !!");

        }

        return employeeLoginDto;
    }

    @Override
    public List<EmployeeCustomDetailsDto> getCustomDtaDto() {
        return this.employee_repo.findAll()
                .stream().
                map(this::CustomEmployeeConvertEntityToDto)
                .collect(Collectors.toList());


    }


    private EmployeeCustomDetailsDto CustomEmployeeConvertEntityToDto(Employee employee) {
        EmployeeCustomDetailsDto employeeDto = new EmployeeCustomDetailsDto();
        employeeDto = modelMapper.map(employee, EmployeeCustomDetailsDto.class);
        return employeeDto;

    }
}
