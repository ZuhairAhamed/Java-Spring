package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			System.out.println("Updating new student object..."+ studentId);
			
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);
			
			session.delete(myStudent); //session.createQuery("delete from Student where id ="2");
			
			session.getTransaction().commit();
			
	
		}finally {
			factory.close();
		}
		

	}

}
