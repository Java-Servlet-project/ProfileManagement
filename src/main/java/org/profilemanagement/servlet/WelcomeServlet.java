package org.profilemanagement.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "WelcomeServlet", urlPatterns = "/welcome", loadOnStartup = 0)
public class WelcomeServlet extends DefaultServlet {

    private static final long serialVersionUID = -5411483885505423770L;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
       printHtmlContent(response, "<h1>Welcome Servlet</h1>");
    }
}
