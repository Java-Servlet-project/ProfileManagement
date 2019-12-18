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
        // try {
        getServletContext().setAttribute("from-welcome-servlet", "context-param-value-2");
        
        final String attrValue = (String) getServletContext().getAttribute("from-welcome-servlet");

        final StringBuffer buffer = new StringBuffer();
        buffer.append("<html><body>");
        buffer.append("<h1> Attribute value = " + attrValue + "</h1>");
        buffer.append("</body></html>");

        printHtmlContent(response, buffer.toString());

        

        // final RequestDispatcher dispatcher = request.getRequestDispatcher("login");
        // final RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.html");
        // dispatcher.forward(request, response);
        // dispatcher.include(request, response);
        // response.sendRedirect("login");

        /*
         * catch (final IOException e) { e.printStackTrace(); }
         *//*
            * catch (final ServletException e) { e.printStackTrace(); }
            */
    }
}
