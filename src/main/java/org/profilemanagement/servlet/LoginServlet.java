package org.profilemanagement.servlet;

import org.profilemanagement.service.LoginLogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/login", loadOnStartup = 0)
public class LoginServlet extends DefaultServlet {

    private static final long serialVersionUID = -3959552837268080363L;

    private LoginLogoutService loginService;
    
    @Override
    public void init() {
        this.loginService = getService(LoginLogoutService.class);
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        final Cookie cookie = loginService.loginAndSetCookie(request);
        if (null != cookie) {
            response.addCookie(cookie);
            final StringBuffer buffer = new StringBuffer();
            buffer.append("<h1>Log In Successfull</h1>");
            buffer.append("<br><hr><br>");
            buffer.append("<a href = 'registration'>Register Now</a>");
            printHtmlContent(response, buffer.toString());
        } else {
            final String content = "<h1>Login failed ! Please try again.</h2>";
            printHtmlContent(response, content);
            final RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.html");
            try {
                dispatcher.include(request, response);
            } catch (final ServletException e) {
                e.printStackTrace();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }
}
