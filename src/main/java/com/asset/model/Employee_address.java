package com.asset.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class Employee_address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_address_id")
    private int employeeAddressId;
    private String state;
    private String country;
    @Column(name = "street_no")
    private int streetNo;
    @Column(name = "house_number")
    private int houseNumber;
    private String landmark;
    @Column(name = "pin_code")
    private int pinCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id",insertable = false,updatable = false)
    private Employee employee;
}
