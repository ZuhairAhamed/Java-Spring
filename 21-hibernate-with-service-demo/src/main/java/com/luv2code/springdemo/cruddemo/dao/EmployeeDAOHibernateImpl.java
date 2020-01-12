package com.luv2code.springdemo.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		Session curSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = curSession.createQuery("from Employee",Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Session curSession = entityManager.unwrap(Session.class);
		
		Employee theEmployee = curSession.get(Employee.class, theId);
		
		return theEmployee;
		
	}

	@Override
	public void save(Employee theEmployee) {
		Session curSession = entityManager.unwrap(Session.class);
		
		curSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteByID(int theId) {
		
		Session curSession = entityManager.unwrap(Session.class);
		
		Query theQuery = curSession.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
	}

}
