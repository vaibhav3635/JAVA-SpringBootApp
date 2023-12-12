package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //Adding Jpa  repository that gives inbuilt methods
    //And passing the Entity and PrimaryKey
}
