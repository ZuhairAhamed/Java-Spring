package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.jpa.event.spi.jpa.ExtendedBeanManager.LifecycleListener;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {

			session.beginTransaction();
			
			List<Student> theStudent = session.createQuery("from Student").getResultList();
			
			for(Student tempStudent : theStudent) {
				System.out.println(tempStudent);
			}
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		

	}

}
