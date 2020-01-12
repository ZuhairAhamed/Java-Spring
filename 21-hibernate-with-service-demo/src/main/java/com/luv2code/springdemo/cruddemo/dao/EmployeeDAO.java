package com.luv2code.springdemo.cruddemo.dao;

import java.util.List;

import com.luv2code.springdemo.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteByID(int theId);

}
