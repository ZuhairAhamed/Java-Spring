package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortuneService() {
		// TODO Auto-generated method stub
		return "This is Random fortune service";
	}

}
