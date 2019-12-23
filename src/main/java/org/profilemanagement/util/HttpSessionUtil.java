package org.profilemanagement.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class HttpSessionUtil {

    public static void setObjectInHttpSession(final HttpServletRequest request, final Object object, final String attrName) {
        final HttpSession httpSession = request.getSession();
        httpSession.setAttribute(attrName, object);
        httpSession.setMaxInactiveInterval(120);
    }

    public static Object getObjectFromSession(final HttpServletRequest request, final String attrName) {
        final HttpSession httpSession = request.getSession(Boolean.FALSE);
        final Object object = httpSession.getAttribute(attrName);
        return object;
    }

    public static void removeObjectFromSession(final HttpServletRequest request, final String attrName) {
        final HttpSession httpSession = request.getSession(Boolean.FALSE);
        httpSession.removeAttribute(attrName);
    }

    public static void invalidateSession(final HttpServletRequest request) {
        request.getSession(Boolean.FALSE).invalidate();
    }
}
