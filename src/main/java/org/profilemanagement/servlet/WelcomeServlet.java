package org.profilemanagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

            //final RequestDispatcher dispatcher = request.getRequestDispatcher("login");
            final RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.html");
            dispatcher.forward(request, response);
            //dispatcher.include(request, response);

        } catch (final IOException e) {
            e.printStackTrace();
        } catch (final ServletException e) {
            e.printStackTrace();
        }
    }
}
