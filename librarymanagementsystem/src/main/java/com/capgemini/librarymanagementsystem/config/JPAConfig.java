package com.capgemini.librarymanagementsystem.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class JPAConfig {

	@Bean
	public LocalEntityManagerFactoryBean getEMF() {
	LocalEntityManagerFactoryBean factoryBean=new LocalEntityManagerFactoryBean();
	factoryBean.setPersistenceUnitName("libraryManagementSystem");
	return factoryBean;
		
	}//end of getEMF
}//end of class
