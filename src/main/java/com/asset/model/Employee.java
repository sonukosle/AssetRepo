package com.asset.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private int empId;
    @Column(name = "emp_name")
    private String empName;
    private String email;
    @Column(name = "emp_password")
    private String empPassword;
    @Column(name = "emp_mobile")
    private String empMobile;
    @Column(name = "emp_age")
    private int empAge;
    @Column(name = "emp_dept")
    private String empDept;
    @Column(name = "emp_year_package")
    private int empYearPackage;
    @Column(name = "emp_designation")
    private String empDesignation;
    @Column(name = "emp_joining_date")
    private String empJoiningDate;
    @Column(name = "emp_fixed_annual_salary")
    private float empFixedAnnualSalary;
    @Column(name = "emp_role")
    private String empRole;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "Address_id")
    private Employee_address employee_address;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Asset_raise_request> asset_raise_requests;
}