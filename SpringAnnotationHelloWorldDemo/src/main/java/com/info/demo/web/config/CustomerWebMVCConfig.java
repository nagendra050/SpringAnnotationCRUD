package com.info.demo.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.info.demo.controller"})
public class CustomerWebMVCConfig extends WebMvcConfigurerAdapter{
     
	/*@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	      registry.addViewController("/").setViewName("home");
	      registry.addViewController("/home.action").setViewName("home");
	      registry.addViewController("/customer/customerForm.action").setViewName("addCustomer");
	 }*/
	
	 @Bean
	 public ViewResolver viewResolver() {
	      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	      viewResolver.setViewClass(JstlView.class);
	      viewResolver.setPrefix("/WEB-INF/views/");
	      viewResolver.setSuffix(".jsp");
	      return viewResolver;
	 } 
}
