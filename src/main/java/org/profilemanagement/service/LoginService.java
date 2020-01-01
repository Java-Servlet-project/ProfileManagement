package org.profilemanagement.service;

import org.profilemanagement.constants.IamConstant;
import org.profilemanagement.dao.DataAccessObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class LoginService {
    
    @Autowired
    private DataAccessObject daoObj;

    public boolean login(final HttpServletRequest request) {
        final String userName = request.getParameter("username");
        final String password = request.getParameter("password");
        return ("Admin".equals(userName) && "mypassword".equals(password)) ? Boolean.TRUE : Boolean.FALSE;
    }

    public Cookie loginAndSetCookie(final HttpServletRequest request) {
        Cookie cookie = null;
        final String userName = request.getParameter("username");
        if (login(request)) {
            cookie = new Cookie(IamConstant.LOGIN_COOKIE_NAME, userName);
            cookie.setMaxAge(1200);
        }
        return cookie;
    }
    
    public void doSome() {
        System.out.println("Calling .... login service @@@@@@@@@@");
        daoObj.daoSome();
    }
}
