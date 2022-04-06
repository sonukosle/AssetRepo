package com.asset.modal;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int emp_id;
    private String emp_name;
    private String emp_email;
    private String emp_password;
    private String emp_mobile;
    private int emp_age;
    private String emp_dept;
    private int emp_year_package;
    private String emp_designation;
    private String emp_joining_date;
    private float emp_fixed_annual_salary;
    private String emp_role;

    @ManyToOne
    private Role role;

    @OneToOne(mappedBy = "employee")
    private Employee_address employee_address;

    @OneToMany(mappedBy = "employee")
    private List<Asset_raise_request> asset_raise_requests;
}
