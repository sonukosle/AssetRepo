package com.asset.modal;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int role_id;
    private String role_name;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "role")
    private List<Employee> employees;

}
