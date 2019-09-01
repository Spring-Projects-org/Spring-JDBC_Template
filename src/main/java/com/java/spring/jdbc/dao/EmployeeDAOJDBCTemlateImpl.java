
package com.java.spring.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.java.spring.jdbc.Employee;
import com.java.spring.jdbc.constant.JDBCConstant;
import com.java.spring.jdbc.mapper.EmployeeRowMapper;

@Component
public class EmployeeDAOJDBCTemlateImpl implements EmployeeDAO {
   
	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Employee employee) {
		String query = "insert into " +JDBCConstant.EmployeeTable+" (id, name, role) values (?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] {employee.getId(), employee.getName(), employee.getRole()};
		int out = jdbcTemplate.update(query, args);
		if(out !=0){
			System.out.println("Employee saved with id="+employee.getId());
		}
		else 
			System.out.println("Employee save failed with id="+employee.getId());
	}

	@Override
	public Employee getById(int id) {
		String query = "select id,name, role from " +JDBCConstant.EmployeeTable+" where id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//using RowMapper anonymous class, we can create a separate RowMapper for reuse
				@SuppressWarnings("unchecked")
				Employee emp = (Employee) jdbcTemplate.queryForObject(query, new Object[]{id}, new EmployeeRowMapper<Employee>());
		
		return emp;
	}

	@Override
	public void update(Employee employee) {
		String query = "update " +JDBCConstant.EmployeeTable+" set name=?, role=? where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] {employee.getName(), employee.getRole(), employee.getId()};
		
		int out = jdbcTemplate.update(query, args);
		if(out !=0){
			System.out.println("Employee updated with id="+employee.getId());
		}else System.out.println("No Employee found with id="+employee.getId());
	}

	@Override
	public void deleteById(int id) {
		String query = "delete from Employee where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		int out = jdbcTemplate.update(query, id);
		if(out !=0){
			System.out.println("Employee deleted with id="+id);
		}else System.out.println("No Employee found with id="+id);
	}

	@Override
	public List<Employee> getAll() {
		String query = "select id, name, role from Employee";
		List<Employee> empList = new ArrayList<Employee>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> empRow : empRows){
			Employee emp = new Employee();
			emp.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
			emp.setName(String.valueOf(empRow.get("name")));
			emp.setRole(String.valueOf(empRow.get("role")));
			empList.add(emp);
		}
		return empList;
	}

}
