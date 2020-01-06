package org.profilemanagement.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.profilemanagement.service.LoginLogoutService;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout", loadOnStartup = 1)
public class LogoutServlet extends DefaultServlet {

    private static final long serialVersionUID = -8504511999191986707L;

    private LoginLogoutService logoutService;
    
    @Override
    public void init() {
        this.logoutService = getService(LoginLogoutService.class);
    }
    
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        final Cookie cookie = logoutService.logout(request);
        if (cookie != null) {
            response.addCookie(cookie);
            printHtmlContent(response, "<h1>Logout Successful !<h1>");
            final RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.html");
            try {
                dispatcher.include(request, response);
            } catch (final ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

}
