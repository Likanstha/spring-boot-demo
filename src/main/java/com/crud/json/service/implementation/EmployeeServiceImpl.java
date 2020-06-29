package com.crud.json.service.implementation;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.crud.json.entity.Employee;
import com.crud.json.repository.EmployeeRepository;
import com.crud.json.service.EmployeeService;




@Service
@Transactional(readOnly = true)
class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOG = LogManager.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

	@Override
	public long findTotalNo() {
		LOG.info("Inside EmployeeServiceImpl#findTotalNo() method.");
		return employeeRepository.count();
	}

	@Override
	public List<Employee> findAll() {
		LOG.info("Inside EmployeeServiceImpl#findAll() method.");
		return (List<Employee>) employeeRepository.findAll();
	}

	@Transactional
	public Employee save(Employee employee) {
		LOG.info("Inside EmployeeServiceImpl#save() method. Article " + employee);
		return employeeRepository.save(employee);	}

	@Override
	public Employee findById(String id) {
		LOG.info("Inside EmployeeServiceImpl#findById() method. Id " + id);
		return employeeRepository.findById(id);
	}

	@Transactional
	public Employee update(Employee employee) {
		LOG.info("Inside EmployeeServiceImpl#update() method. Article : " + employee);
		return employeeRepository.save(employee);
	}

	@Transactional
	public void delete(Employee employee) {
		LOG.info("Inside EmployeeServiceImpl#delete() method. Article : " + employee);
		employeeRepository.delete(employee);
		
	}

    

}