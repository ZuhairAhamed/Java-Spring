package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts =null; 
		
		try {
			boolean tripwire = false;
			theAccounts = theAccountDAO.findAccounts(tripwire);
			
		} catch (Exception e) {
			System.out.println("New Exception thrown: "+e);
		}

		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println(theAccounts);
		
		// close the context
		context.close();
	}

}










