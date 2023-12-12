package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //define the EmloyeeService
    private EmployeeService employeeService;
    //Inject the EmployeeService as we will not e using DAO directly
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping("/findAll")
    public List<Employee> findAllEmployee(){
        return employeeService.findAll();
    }
    @GetMapping("employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee==null){
            throw new EmployeeNotFoundException("Employee NOT fOUND"+employeeId);
        }
        return employee;
    }
    //Add the employee
    @PostMapping("/employee/create")
    public Employee createEmployee(@RequestBody Employee theEmployee){
        //if client sends to update a specific employee thats why employeeId
       String email= theEmployee.getEmail();//getting the employee emial from the body
        Employee Dbemployee = employeeService.save(theEmployee);
        //An employee will be returned
        return Dbemployee;
    }
    @PutMapping("/employee/update/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee theEmployee,@PathVariable int employeeId){
        //Finding the Employee using the PathVariable;
        Employee employee1 = employeeService.findById(employeeId);
       employee1.setFirstName(theEmployee.getFirstName());
       employee1.setLastName(theEmployee.getLastName());
       employee1.setEmail(theEmployee.getEmail());
        Employee dbEmployee = employeeService.save(employee1);
        return dbEmployee;
    }
    @DeleteMapping("employee/delete")
    public void deleteEmployee(@RequestParam int employeeId,@RequestParam String test){
        String val = test;
        int emp = employeeId;
        Employee employee = employeeService.findById(employeeId);
        if(employee ==null){
            throw new EmployeeNotFoundException("Employee not found");
        }
        employeeService.delete(employeeId);
    }
}
