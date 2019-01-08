package com.mycompany.app.aspectvalidation;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {
	 Logger logger=Logger.getLogger(ValidationAspect.class.getName());
	 
	 @Before("execution(* com.mycompany.app..*(..))")
	 public void log1() {
		 logger.info("Before - logging the method");
	 }
	 
	 @After("execution(* com.mycompany.app..*(..))")
	 public void log2() {
		 logger.info("After - logging the method");
	 }
	 
	/* @Around("execution(* com.mycompany.app..*(..))")
	 public void log3(ProceedingJoinPoint pjp)throws Throwable{
		 logger.info("Before - logging the method");
		 logger.info("Function name is: " +pjp.getSignature());
		 logger.info("Parameters are:");
		 Object[] params=pjp.getArgs();
		 for(int i=0;i<params.length;i++)
		 {
			 logger.info("parameter value at index " +i+ "is" +params[i]);
		 }
		int retVal= (Integer) pjp.proceed();
		 logger.info("After - logging the method");
		 return retVal;
	 } */
	 
	 @Around("execution(* com.mycompany.app..*(..))")
	 public void log3(ProceedingJoinPoint pjp)throws Throwable{
		 Object[] params=pjp.getArgs();
		 if((Integer) params[0] == 0 && (Integer) params[1] == 0)
			 logger.info("sry!!! You cannot give o Give any other value ");
		 else {
			 pjp.proceed();
			 logger.info("After - logging the method");
		 }
	 }
	 
	 
	/* @AfterReturning(pointcut="execution(* com.mycompany.app..*(..))",returning="retVal")
	 public void log5(int retVal)
	 {
		logger.info(" "+retVal);
	 }*/
	
}
