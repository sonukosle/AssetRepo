package com.asset.dto;

import com.asset.model.Asset_raise_request;
import com.asset.model.Employee_address;
import com.asset.model.Role;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {

    private int empId;
    private String empName;
    private String email;
    private String empPassword;
    private String empMobile;
    private int empAge;
    private String empDept;
    private int empYearPackage;
    private String empDesignation;
    private String empJoiningDate;
    private float empFixedAnnualSalary;
    private String empRole;


//    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;

//    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
    private Employee_address employee_address;

//    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Asset_raise_request> asset_raise_requests;
}
