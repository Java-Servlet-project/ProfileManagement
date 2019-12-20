package org.profilemanagement.servlet;

import org.profilemanagement.service.LoginService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends DefaultServlet {

    private static final long serialVersionUID = -3959552837268080363L;

    private final LoginService loginService = new LoginService();

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {

    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        final Cookie cookie = loginService.loginAndSetCookie(request);
        if (null != cookie) {
            response.addCookie(cookie);
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
