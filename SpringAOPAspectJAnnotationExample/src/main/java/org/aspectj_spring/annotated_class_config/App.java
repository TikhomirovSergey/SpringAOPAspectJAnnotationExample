package org.aspectj_spring.annotated_class_config;


import org.aspectj_spring.service.CustomerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SuppressWarnings("resource")
public class App {
	public static void main(String[] args) throws Exception {

		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
		AnnotationConfigApplicationContext appContext2 = new AnnotationConfigApplicationContext(Config.class);
		
		CustomerService customer = (CustomerService) appContext.getBean("customerService", "bla-bla");
		CustomerService customer2 = (CustomerService) appContext2.getBean("customerService", "bla-bla bla-bla");

		customer.addCustomer();
		customer2.addCustomer();
		customer2.addCustomer();
		customer.addCustomer();
		
		customer.addCustomerReturnValue();
		
		customer.addCustomerAround("javaxblog");
		
		customer.addCustomerThrowException();		

	}
}