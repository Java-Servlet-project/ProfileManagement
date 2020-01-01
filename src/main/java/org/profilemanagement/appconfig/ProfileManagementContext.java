package org.profilemanagement.appconfig;

import org.profilemanagement.service.LoginService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ProfileManagementContext extends ContextLoaderListener { // implements
                                                                      // ServletContextListener

    public AnnotationConfigWebApplicationContext springContext = null;

    @Override
    public void contextInitialized(final ServletContextEvent event) {
        springContext = new AnnotationConfigWebApplicationContext(); 
        springContext.register(SpringJavaConfig.class);
        springContext.refresh();
        if (springContext != null) {
            event.getServletContext().log("###### Context Initialized ##########");
            final ServletContext context = event.getServletContext();
            context.setAttribute("loginService", springContext.getBean(LoginService.class));
            //event.getServletContext().setAttribute("springContext", springContext);
            //LoginService ser = springContext.getBean(LoginService.class);
            //ser.doSome();
        } else {
            event.getServletContext().log("###### Context Null ##########");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        if (null != springContext)
            event.getServletContext().log("###### Context Destroyed ##########");
            springContext.close();
    }


}
