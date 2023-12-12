package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.DAO.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.rest.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Adding the @Service Annotation
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee findById(int theid) {
        Optional<Employee> result = employeeRepository.findById(theid);
        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee=result.get();
        }else {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        return theEmployee;
    }
//Adding Transactional Annotation for thr Service layer

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

}
