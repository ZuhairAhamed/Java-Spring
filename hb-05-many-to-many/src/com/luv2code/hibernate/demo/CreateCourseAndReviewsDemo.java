package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman: How to score");
			
			tempCourse.addReview(new Review("Great course"));
			tempCourse.addReview(new Review("Cool course"));
			tempCourse.addReview(new Review("Best course"));
			tempCourse.addReview(new Review("Loved the course"));
			
			
			session.save(tempCourse);
			
			session.getTransaction().commit();
			
			System.out.println("Done 1");
			
		}finally {
			
			//add clean up code
			session.close();
			factory.close();
		}
		

	}

}
