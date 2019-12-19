package org.profilemanagement.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends DefaultServlet {

    private static final long serialVersionUID = -2788867788048189231L;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {

        final String value = "<h1> From Profile Servlet : " + getServletContext().getAttribute("from-welcome-servlet") + "</h1>";
        printHtmlContent(response, value);
    }

}
