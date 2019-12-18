package org.profilemanagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.profilemanagement.service.LoginService;

public class LoginServlet extends DefaultServlet {

    private static final long serialVersionUID = -3959552837268080363L;
    
    private final LoginService loginService = new LoginService();
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        final String attrValue = (String) getServletContext().getAttribute("from-welcome-servlet");
        
        final StringBuffer buffer = new StringBuffer();
        buffer.append("<html><body>");
        buffer.append("<h1> Attribute value = " + attrValue + "</h1>");
        buffer.append("</body></html>");
        
        printHtmlContent(response, buffer.toString());
        getServletContext().removeAttribute("from-welcome-servlet");
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        if (loginService.login(request)) {
            final String content = "<h1>Log In Successfull</h1>";
            printHtmlContent(response, content);
        } else {
            final String content = "<h1>Login failed ! PLease try again.</h2>";
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
