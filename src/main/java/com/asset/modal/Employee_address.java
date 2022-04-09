package com.asset.modal;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Employee_address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int employee_address_id;
    private String state;
    private String country;
    private int street_no;
    private int house_number;
    private String landmark;
    private int pin_code;

    @OneToOne
    private Employee employee;
}
