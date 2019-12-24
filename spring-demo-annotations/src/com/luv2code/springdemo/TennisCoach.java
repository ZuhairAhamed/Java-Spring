package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;

//	Constructor injection
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}
	
//	Setter injection
	@Autowired
	@Qualifier("randomFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "This is for tennis coach";
	}

	@Override
	public String getMonthlyWorkout() {
		// TODO Auto-generated method stub
		return "This is for default bean id as tennisCoach";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortuneService();
	}

}
