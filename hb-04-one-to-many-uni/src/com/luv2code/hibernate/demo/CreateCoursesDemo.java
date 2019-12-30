package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			session.beginTransaction();
			
			int theId =1;
			Instructor tempIntructor = session.get(Instructor.class, theId);
			
			Course temp1 = new Course("Java Development");
			Course temp2 = new Course("Python Programming");
			
			tempIntructor.add(temp1);
			tempIntructor.add(temp2);

			session.save(temp1);
			session.save(temp2);
			
			session.getTransaction().commit();
			
			System.out.println("Done 1");
			
		}finally {
			
			//add clean up code
			session.close();
			factory.close();
		}
		

	}

}
