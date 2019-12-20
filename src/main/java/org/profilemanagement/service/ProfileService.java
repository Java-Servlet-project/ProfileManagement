package org.profilemanagement.service;

import org.profilemanagement.constants.IamConstant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ProfileService {

    public String userProfile(final HttpServletRequest request) {
        final StringBuffer buffer = new StringBuffer();
        final Cookie[] cookies = request.getCookies();
        for (final Cookie cookie : cookies) {
            if (IamConstant.LOGIN_COOKIE_NAME.equals(cookie.getName())) {
                buffer.append("<h1>Hello ").append(cookie.getValue()).append(" ! ");
                buffer.append("This is your profile</h1>");
            }
        }
        return buffer.toString();
    }
}
