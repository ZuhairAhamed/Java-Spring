package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int instructorId = 1;
			
			session.beginTransaction();
			
			Instructor tempInstructor = session.get(Instructor.class, instructorId);
			
			if(tempInstructor != null) {
				System.out.println("Deleting .... "+ tempInstructor);
				
				session.delete(tempInstructor);
			}
			
			session.getTransaction().commit();
			
			System.out.println("Done 1");
			
		}finally {
			factory.close();
		}
		

	}

}
