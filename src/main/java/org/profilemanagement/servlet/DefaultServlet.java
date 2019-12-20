package org.profilemanagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class DefaultServlet extends HttpServlet {

    private static final long serialVersionUID = -667453708120657838L;
    
    protected void printHtmlContent(final HttpServletResponse response, final String content) {
        try {
            response.setContentType("text/html");
            final PrintWriter writer = response.getWriter();
            writer.println("<html><body>");
            writer.println(content);
            writer.println("</body></html>");
            writer.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
