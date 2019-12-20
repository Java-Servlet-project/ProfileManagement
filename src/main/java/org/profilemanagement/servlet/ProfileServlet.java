package org.profilemanagement.servlet;

import org.profilemanagement.service.ProfileService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends DefaultServlet {

    private static final long serialVersionUID = -2788867788048189231L;

    private ProfileService profileService = new ProfileService();

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        printHtmlContent(response, profileService.userProfile(request));
    }

}
