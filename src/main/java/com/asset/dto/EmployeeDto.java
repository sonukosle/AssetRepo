package com.asset.dto;

import com.asset.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
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


    private Role role;
    private Employee_address employee_address;
    private List<Asset_raise_request> asset_raise_requests;
    private Asset_track asset_track;
    private Asset asset;
}
