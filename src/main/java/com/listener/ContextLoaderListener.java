package com.listener;

import com.configuration.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        //        ApplicationContext aa = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext aa = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("aa",aa);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
