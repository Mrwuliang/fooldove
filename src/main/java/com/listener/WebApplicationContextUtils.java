package com.listener;

import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;

public class WebApplicationContextUtils {
    public static ApplicationContext getWebApplicationContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("aa");
    }
}
