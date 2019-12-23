package org.profilemanagement.service;

import org.profilemanagement.constants.IamConstant;
import org.profilemanagement.model.Employee;
import org.profilemanagement.util.HttpSessionUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class RegistrationService {

    public boolean registerUser(final HttpServletRequest request) {
        boolean isSuccess = Boolean.FALSE;
        final Employee employee = new Employee();
        employee.setFirstName(request.getParameter("firstname"));
        employee.setMiddleName(request.getParameter("middlename"));
        employee.setLastName(request.getParameter("lastname"));

        final Cookie[] cookies = request.getCookies();
        for (final Cookie cookie : cookies) {
            if (IamConstant.LOGIN_COOKIE_NAME.equals(cookie.getName())) {
                HttpSessionUtil.setObjectInHttpSession(request, employee, cookie.getValue());
                isSuccess = Boolean.TRUE;
            }
        }
        return isSuccess;
    }
}
