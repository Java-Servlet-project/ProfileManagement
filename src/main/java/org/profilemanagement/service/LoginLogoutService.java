package org.profilemanagement.service;

import org.profilemanagement.constants.IamConstant;
import org.profilemanagement.dao.DataAccessObject;
import org.profilemanagement.util.HttpSessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class LoginLogoutService {
    
    @Autowired
    private DataAccessObject daoObj;

    public Cookie loginAndSetCookie(final HttpServletRequest request) {
        Cookie cookie = null;
        if (login(request)) {
            cookie = new Cookie(IamConstant.LOGIN_COOKIE_NAME, request.getParameter("username"));
            cookie.setMaxAge(1200);
        }
        return cookie;
    }
    
    public Cookie logout(final HttpServletRequest request) {
        final Cookie cookie = new Cookie(IamConstant.LOGIN_COOKIE_NAME, "");
        cookie.setMaxAge(0);
        HttpSessionUtil.invalidateSession(request);
        return cookie;
    }
    
    private boolean login(final HttpServletRequest request) {
        final String userName = request.getParameter("username");
        final String password = request.getParameter("password");
        return "Admin".equals(userName) && "mypassword".equals(password);
    }
}
