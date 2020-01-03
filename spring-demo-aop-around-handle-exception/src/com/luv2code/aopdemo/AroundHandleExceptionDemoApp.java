package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;


public class AroundHandleExceptionDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneservice = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: Around Demo");
		
		myLogger.info("Calling getFortune");
		
		boolean tripwire = true;
		
		String data = theFortuneservice.getFortune(tripwire);
		
		myLogger.info("\nMy fortune is :" + data);
		
		myLogger.info("Finished");
		
		// close the context
		context.close();
	}

}










