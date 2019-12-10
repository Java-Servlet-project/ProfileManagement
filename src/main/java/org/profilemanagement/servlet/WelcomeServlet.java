package org.profilemanagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends DefaultServlet {

    private static final long serialVersionUID = -5411483885505423770L;
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        try {
            final PrintWriter writer = response.getWriter();
            writer.println("<html><body>");
            writer.println("<h1>Welcome to profile management : Servlet<h1>");
            writer.println("</body></html>");
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
