package org.profilemanagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends DefaultServlet {

    private static final long serialVersionUID = -3959552837268080363L;
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        try {
            final PrintWriter writer = response.getWriter();
            writer.println("<html><body>");
            writer.println("<h1>This is Login Servlet<h1>");
            writer.println("</body></html>");
        } catch (final IOException e) {
            e.printStackTrace();
        }       
    }
}
