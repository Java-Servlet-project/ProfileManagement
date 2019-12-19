package org.profilemanagement.servlet;

import org.profilemanagement.service.LoginService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends DefaultServlet {

    private static final long serialVersionUID = -3959552837268080363L;

    private final LoginService loginService = new LoginService();

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        final StringBuffer buffer = new StringBuffer();
        buffer.append("<h1> Login Servlet Attribute value = " + getServletContext().getAttribute("from-welcome-servlet") + "</h1>");
        buffer.append("<h2> From request attr : " + request.getAttribute("req-attr") + "</h2>");
        printHtmlContent(response, buffer.toString());

        getServletContext().removeAttribute("from-welcome-servlet");

        if (getServletContext().getAttribute("from-welcome-servlet") == null) {
            getServletContext().setAttribute("from-login-servlet", "I am updated value");
        }
    }

    @Override
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
