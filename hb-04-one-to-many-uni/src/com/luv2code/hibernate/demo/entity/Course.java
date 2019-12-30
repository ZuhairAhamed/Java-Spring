package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String titile;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<Review> Reviews;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String titile) {
		this.titile = titile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitile() {
		return titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	

	public List<Review> getReviews() {
		return Reviews;
	}

	public void setReviews(List<Review> reviews) {
		Reviews = reviews;
	}
	
	//add a convenience method
	public void addReview(Review theReview) {
		if(Reviews == null) {
			Reviews = new ArrayList<>();
		}
		Reviews.add(theReview);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", titile=" + titile + ", instructor=" + instructor + "]";
	}
	
	
	
}
