package com.crud.json.startup;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crud.json.entity.Employee;
import com.crud.json.repository.EmployeeRepository;

@Component
public class Startup{
    @Autowired
    private EmployeeRepository employeeRepository;

    Employee employee = new Employee();
    @PostConstruct
     private  void postConstruct(){
         employee.setName("test");
         employee.setPhone("20");
         employee.setAddress("pjf");
         employee.setDesignation("nkdf");
         employee.setEmail("nsdk");
         employee.setSalary("100");
         employeeRepository.save(employee);
     }
}