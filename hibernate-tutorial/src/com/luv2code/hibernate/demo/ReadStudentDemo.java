package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("zuhair","ahamed","ahamed@luv2code.com");
			
			session.beginTransaction();
			
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			//My new code
			
			System.out.println("Reading student object...");
			System.out.println("Saved student: Generated Id: "+ tempStudent.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student with id : "+tempStudent.getId());
			
			Student myStudent=  session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get Complete: "+ myStudent);
			
			session.getTransaction().commit();
			
			
			
		}finally {
			factory.close();
		}
		

	}

}
