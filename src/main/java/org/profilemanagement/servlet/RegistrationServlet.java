package org.profilemanagement.servlet;

import org.profilemanagement.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends DefaultServlet {

    private static final long serialVersionUID = -5205945246703575315L;

    @Autowired
    private RegistrationService registrationService;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        try {
            response.sendRedirect("views/registration.html");
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        if (registrationService.registerUser(request)) {
            final StringBuffer buffer = new StringBuffer();
            buffer.append("<h1>Registration Successfull ! <h1>");
            buffer.append("<br><hr><br>");
            buffer.append("<a href = 'profile'>Go To Profile</a>");
            printHtmlContent(response, buffer.toString());
        }
    }

}
