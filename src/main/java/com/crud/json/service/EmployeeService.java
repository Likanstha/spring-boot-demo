package com.crud.json.service;

import java.util.List;

import com.crud.json.entity.Employee;

public interface EmployeeService {

	
	long findTotalNo();

	List<Employee> findAll();

	Employee save(Employee employee);


	Employee findById(String id);

	
	Employee update(Employee employee);


	void delete(Employee employee);

}