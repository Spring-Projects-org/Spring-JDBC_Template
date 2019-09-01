package com.java.spring.jdbc.client;

import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.java.spring.jdbc.Employee;
import com.java.spring.jdbc.config.SpringJdbcConfig;
import com.java.spring.jdbc.dao.EmployeeDAO;

public class TestClientJDBC {
	
	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
		
		EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);
		//Run some tests for JDBC CRUD operations
				Employee employee = new Employee();
				int rand = new Random().nextInt(1000);
				employee.setId(rand);
				employee.setName("Rahat");
				employee.setRole("Senior Programmer");
				//Create
				employeeDAO.save(employee);
				
				//Read
				//System.out.println("Reading Employee Data for Id:"+26);
				Employee emp1 = employeeDAO.getById(rand);
				
				System.out.println("Employee Retrieved::"+emp1);
				
				//Update
				employee.setRole("CEO");
				employeeDAO.update(employee);
				
				//Get All
				List<Employee> empList = employeeDAO.getAll();
				System.out.println(empList);
				
				//Delete
				//employeeDAO.deleteById(rand);
				
				//Close Spring Context
				((AbstractApplicationContext) context).close();
				
				System.out.println("DONE");
		
	}
	
	
			

}
