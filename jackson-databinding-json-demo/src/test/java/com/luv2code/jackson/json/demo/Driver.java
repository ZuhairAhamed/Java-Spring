package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read the json file and map/convert to Java POJO
			Student thStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print the fields
			System.out.println("First Name: "+ thStudent.getFirstName());
			System.out.println("Last Name: "+ thStudent.getLastName());
			
			Address tempAdd = thStudent.getAddress();
			System.out.println("Address: "+ tempAdd.getStreet()+", "+tempAdd.getCity()+", "+tempAdd.getCity()+", "+tempAdd.getState()+", "+tempAdd.getCountry());
			
			for (String lan : thStudent.getLanguages()) {
				System.out.print(lan+ " ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
