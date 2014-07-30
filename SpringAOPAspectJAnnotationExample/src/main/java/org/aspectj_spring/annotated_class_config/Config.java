package org.aspectj_spring.annotated_class_config;

import org.aspectj_spring.aspect.CustomerAspect;
import org.aspectj_spring.service.CustomerService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableAspectJAutoProxy
public class Config {
    private String aspectString;
	
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean(name = "customerService")
	public CustomerService getCustomerService(String string){
		aspectString = string;
		return new CustomerService(string);
	}
	
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean(name = "customerAspect")
	public CustomerAspect getAspect(){
		return new CustomerAspect(aspectString);
	}

}
