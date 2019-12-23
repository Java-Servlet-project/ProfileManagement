package org.profilemanagement.service;

import org.profilemanagement.constants.IamConstant;
import org.profilemanagement.model.Employee;
import org.profilemanagement.util.HttpSessionUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class ProfileService {

    public String userProfile(final HttpServletRequest request) {
        final StringBuffer buffer = new StringBuffer();
        final Cookie[] cookies = request.getCookies();
        for (final Cookie cookie : cookies) {
            if (IamConstant.LOGIN_COOKIE_NAME.equals(cookie.getName())) {
                buffer.append("<h1>Hello ").append(cookie.getValue()).append(" ! ");
                final Employee employee = (Employee) HttpSessionUtil.getObjectFromSession(request, cookie.getValue());
                buffer.append("<h2> First Name - " + employee.getFirstName() + "</h2>");
                buffer.append("<h2> Middle Name - " + employee.getMiddleName() + "</h2>");
                buffer.append("<h2> Last Name - " + employee.getLastName() + "</h2>");
            }
        }
        return buffer.toString();
    }
}
