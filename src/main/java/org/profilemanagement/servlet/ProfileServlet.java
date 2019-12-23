package org.profilemanagement.servlet;

import org.profilemanagement.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends DefaultServlet {

    private static final long serialVersionUID = -2788867788048189231L;

    @Autowired
    private ProfileService profileService;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        printHtmlContent(response, profileService.userProfile(request));
    }

}
