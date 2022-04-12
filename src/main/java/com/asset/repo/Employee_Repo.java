package com.asset.repo;

import com.asset.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Employee_Repo extends JpaRepository<Employee, Integer> {

//    @Query("SELECT e FROM Employee e where e.email = :email")
    public Employee findByEmail(String email);

    @Query("select e FROM Employee e")
    List<Employee>getAll();

}
