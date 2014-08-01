package org.aspectj_spring.aspect;
 
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
 
@Aspect
public class CustomerAspect {
	private static int i=0;
	@SuppressWarnings("unused")
	private final int index;
	
	public CustomerAspect(){
		super();
		i++;
		index = i;
	}
	
	public CustomerAspect(String string){
		super();
		i++;
		index = i;
	}	
	
	@Before("execution(* org.aspectj_spring.service.AbstractCustService.addCustomer(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("logBefore() is running!");
		System.out.println("Signature name : " + joinPoint.getSignature().getName());
		System.out.println("******");
		joinPoint.getArgs();
		joinPoint.getSignature();
		joinPoint.getTarget();
	}

	@After("execution(* org.aspectj_spring.service.CustomerService.addCustomer(..))")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("logAfter() is running!");
		System.out.println("Signature name : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
	
	@AfterReturning(
			pointcut = "execution(* org.aspectj_spring.service.CustomerService.addCustomerReturnValue(..))",
			returning= "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		System.out.println("logAfterReturning() is running!");
		System.out.println("Signature name : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");

	}
	
	@AfterThrowing(
			pointcut = "execution(* org.aspectj_spring.service.CustomerService.addCustomerThrowException(..))",
			throwing= "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

		System.out.println("logAfterThrowing() is running!");
		System.out.println("Signature name : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");

	}
	
	
	@Around("execution(* org.aspectj_spring.service.AddsCustomerAround.addCustomerAround(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("logAround() is running!");
		System.out.println("Signature name : " + joinPoint.getSignature().getName());
		System.out.println("Arguments : " + Arrays.toString(joinPoint.getArgs()));
		
		System.out.println("Around before is running!");
		joinPoint.proceed();
		System.out.println("Around after is running!");
		
		System.out.println("******");

	}
 
}