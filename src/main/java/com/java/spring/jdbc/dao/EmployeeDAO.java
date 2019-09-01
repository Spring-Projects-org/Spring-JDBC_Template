
package com.java.spring.jdbc.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.java.spring.jdbc.Employee;

//CRUD operations
@Component
public interface EmployeeDAO {
	
	//Create
	public void save(Employee employee);
	//Read
	public Employee getById(int id);
	//Update
	public void update(Employee employee);
	//Delete
	public void deleteById(int id);
	//Get All
	public List<Employee> getAll();
}
