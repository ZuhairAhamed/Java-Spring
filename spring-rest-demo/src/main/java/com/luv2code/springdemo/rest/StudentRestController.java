package com.luv2code.springdemo.rest;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define @PostConstruct to load the student data ... only once!
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<Student>();
		
		theStudents.add(new Student("Zuhair","Ahamed"));
		theStudents.add(new Student("Mario","Rosi"));
		theStudents.add(new Student("Mary","Smith"));
		
	}
	

	@GetMapping("/students")
	public List<Student> getStudents(){

		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if((studentId >= theStudents.size()) || (studentId < 0 )) {
			throw new StudentNotFoundException("Student id not found : " + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	/*
	//Add an exception handler usnig @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		//create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//Return ResponseEntity
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	//Add another exeption handler ... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		//create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
				
		//Return ResponseEntity
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}*/
	
}
 






















