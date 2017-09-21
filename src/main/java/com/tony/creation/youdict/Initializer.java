package com.tony.creation.youdict;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.tony.creation.controllers.ControllerConfig;

/**
 * Starting point of the program
 * @author Hanxiao
 *
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
	@Override
    public void onStartup(ServletContext container) throws ServletException {
 
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(ControllerConfig.class);
        ctx.setServletContext(container);
 
        ServletRegistration.Dynamic servlet = 
        		container.addServlet("dispatcher", new DispatcherServlet(ctx)); // DispatcherServlet
 
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        

//		try {
//			initialize(context);
//		} catch (IOException exception) {
//			throw new ServletException(exception);
//		}
    }

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ControllerConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
 
}