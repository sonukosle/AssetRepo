package com.asset.model;

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
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int role_id;
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id")
    private List<Employee> employees;

}
