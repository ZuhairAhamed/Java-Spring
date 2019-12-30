package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman: How to score");

			session.save(tempCourse);
			
			Student tempStudent1 = new Student("John","Doe","john@gmail.com");
			Student tempStudent2 = new Student("Marry","Doe","john@gmail.com");
			
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			session.getTransaction().commit();
			
			System.out.println("Done 1");
			
		}finally {
			
			//add clean up code
			session.close();
			factory.close();
		}
		

	}

}
