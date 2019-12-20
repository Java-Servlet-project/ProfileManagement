package org.profilemanagement.service;

import org.profilemanagement.constants.IamConstant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class LoginService {

    public boolean login(final HttpServletRequest request) {
        final String userName = request.getParameter("username");
        final String password = request.getParameter("password");
        return ("Admin".equals(userName) && "mypassword".equals(password)) ? Boolean.TRUE : Boolean.FALSE;
    }

    public Cookie loginAndSetCookie(final HttpServletRequest request) {
        Cookie cookie = null;
        final String userName = request.getParameter("username");
        final String password = request.getParameter("password");
        if ("Admin".equals(userName) && "mypassword".equals(password)) {
            cookie = new Cookie(IamConstant.LOGIN_COOKIE_NAME, userName);
            cookie.setMaxAge(120);
        }
        return cookie;
    }
}
