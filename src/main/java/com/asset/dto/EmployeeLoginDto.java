package com.asset.dto;

import com.asset.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class EmployeeLoginDto {

    private String email;
    private String empPassword;
    private Role role;

}
