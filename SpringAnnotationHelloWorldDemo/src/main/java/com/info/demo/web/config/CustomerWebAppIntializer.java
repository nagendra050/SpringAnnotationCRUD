package com.info.demo.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;


public class CustomerWebAppIntializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext container) throws ServletException {
	
      AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
	       webContext.register(CustomerWebMVCConfig.class);
	       webContext.setServletContext(container);
	       ServletRegistration.Dynamic reg=container.addServlet("dispatcherServlet", new DispatcherServlet(webContext));
	       reg.setLoadOnStartup(1);
	       reg.addMapping("/");
		
	}

	

}
