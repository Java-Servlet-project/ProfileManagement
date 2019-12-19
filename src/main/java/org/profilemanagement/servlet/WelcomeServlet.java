package org.profilemanagement.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends DefaultServlet {

    private static final long serialVersionUID = -5411483885505423770L;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        getServletContext().setAttribute("from-welcome-servlet", "I am from servlet context attribute");
        request.setAttribute("req-attr", "Its from request attr");

        final String attrValue = (String) getServletContext().getAttribute("from-welcome-servlet");
        final String attrValue1 = (String) getServletContext().getAttribute("from-login-servlet");

        final StringBuffer buffer = new StringBuffer();
        buffer.append("<h1> Welcome Servlet Attribute value = " + attrValue + "</h1>");
        buffer.append("<h1> Welcome Servlet Attribute value = " + attrValue1 + "</h1>");

        printHtmlContent(response, buffer.toString());
    }
}
