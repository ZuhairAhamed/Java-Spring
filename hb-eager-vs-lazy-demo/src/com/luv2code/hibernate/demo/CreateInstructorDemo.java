package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Instructor tempInstructor = new Instructor("fathima","amai","amai@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("link","reading");
			
			tempInstructor.setInstrctorDetail(tempInstructorDetail);
	
			session.beginTransaction();
			
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done 1");
			
		}finally {
			
			//add clean up code
			session.close();
			factory.close();
		}
		

	}

}
