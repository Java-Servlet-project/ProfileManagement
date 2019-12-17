package org.profilemanagement.service;

import javax.servlet.http.HttpServletRequest;

public class LoginService {
    
    public boolean login(final HttpServletRequest request) {
        final String userName = request.getParameter("username");
        final String password = request.getParameter("password");
        return ("Admin".equals(userName) && "mypassword".equals(password)) ? Boolean.TRUE : Boolean.FALSE;
    }

}
