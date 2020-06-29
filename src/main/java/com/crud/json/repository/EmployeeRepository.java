package com.crud.json.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crud.json.entity.Employee;



@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
   Employee findById(String id);

}
