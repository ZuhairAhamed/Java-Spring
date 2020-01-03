package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {		
		myLogger.info("\n=====>>> Executing @Before advice on method");
		
		//display the method signature
		MethodSignature mithodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info(mithodSig.toString());
		
		//display method arguments
		Object[] args = theJoinPoint.getArgs();
		for(Object tempArg: args) {
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account)tempArg;
				myLogger.info("account name: "+ theAccount.getName());
				myLogger.info("account level: "+ theAccount.getLevel());
			}
		}
		
	}
	
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Executing @AfterReturning on method: "+method);
		
		myLogger.info("\n=======>>> result is: "+result);
		
		convertAccountNameToUpperCase(result);
		
		myLogger.info("\n=======>>> result is: "+result);
	}

	private void convertAccountNameToUpperCase(List<Account> result) {
		
		for(Account tempAccount : result ) {
			
			String theUpperName = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperName);
		}
		
	}
	
	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Executing @AfterThrowing on method: "+method);
		
		myLogger.info("\n======>>> The exception is : "+theExc);
		
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Executing @After (Finally) on method: "+method);
	}
	
	@Around("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object arroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Executing @Around on method: "+method);
		
		long begin= System.currentTimeMillis();
		
		Object result = theProceedingJoinPoint.proceed();
		
		long end= System.currentTimeMillis();
		
		long duration = end - begin;
		
		myLogger.info("\nDuration: "+ duration/1000.0+ "seconds");
		
		return result;
		
	}
	
	
}










