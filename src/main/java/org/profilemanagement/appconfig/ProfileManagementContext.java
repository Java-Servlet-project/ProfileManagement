package org.profilemanagement.appconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ProfileManagementContext implements ServletContextListener {

    private AbstractApplicationContext springAppContext = null;

    @Override
    public void contextInitialized(final ServletContextEvent event) {
        final ServletContext servletContext = event.getServletContext();
        springAppContext = new AnnotationConfigApplicationContext(SpringJavaConfig.class); 
        if (springAppContext != null) {
            servletContext.log("###### Context Initialized ##########");
            servletContext.setAttribute("springAppContext", springAppContext);
        } else {
            servletContext.log("###### Context Null ##########");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        if (null != springAppContext) {
            event.getServletContext().log("###### Context Destroyed ##########");
        }
        springAppContext.close();
    }
}
