package com.asset.repo;

import com.asset.dto.EmployeeDto;
import com.asset.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee_Repo extends JpaRepository<Employee,Integer> {

    public Employee findByEmail(String email);

}
