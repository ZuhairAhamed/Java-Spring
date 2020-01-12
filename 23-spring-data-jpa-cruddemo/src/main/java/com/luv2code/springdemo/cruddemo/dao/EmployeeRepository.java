package com.luv2code.springdemo.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springdemo.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
