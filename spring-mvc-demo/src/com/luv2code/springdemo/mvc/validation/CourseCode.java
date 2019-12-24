package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) //use CourseCodeConstraintValidator class
@Target({ElementType.METHOD, ElementType.FIELD}) //can apply to method and field
@Retention(RetentionPolicy.RUNTIME) //process it at runtime
public @interface CourseCode {

	//value for the coursecode
	public String value() default "LUV";
	
	//error message for the coursecode
	public String message() default "must start with LUV";
	
	//define default groups
	public Class<?>[] groups() default {}; //Groups : can group related constraints
	
	//define default payloads
	public Class<? extends Payload>[] payload() default {};
}
