package org.profilemanagement.servlet;

import org.profilemanagement.service.ProfileService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile", loadOnStartup = 1)
public class ProfileServlet extends DefaultServlet {

    private static final long serialVersionUID = -2788867788048189231L;

    private ProfileService profileService;
    
    @Override
    public void init() {
        this.profileService = getService(ProfileService.class);
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        printHtmlContent(response, profileService.userProfile(request));
    }

}
