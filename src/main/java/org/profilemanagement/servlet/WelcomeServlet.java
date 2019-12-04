package org.profilemanagement.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends DefaultServlet {

    private static final long serialVersionUID = -5411483885505423770L;
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        try {
            response.getWriter().println("Welcome to profile management");
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
