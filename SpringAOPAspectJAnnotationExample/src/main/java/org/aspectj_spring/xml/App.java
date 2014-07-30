package org.aspectj_spring.xml;


import org.aspectj_spring.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) throws Exception {

		@SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Customer.xml");

		CustomerService customer = (CustomerService) appContext.getBean("customerService");
		CustomerService customer2 = (CustomerService) appContext.getBean("customerService");

		customer.addCustomer();
		customer2.addCustomer();
		
		customer.addCustomerReturnValue();
		
		customer.addCustomerAround("javaxblog");
		
		customer.addCustomerThrowException();		

	}
}