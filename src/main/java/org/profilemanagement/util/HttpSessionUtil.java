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
        Object object = null;
        final HttpSession httpSession = request.getSession(Boolean.FALSE);
        object = httpSession != null ? httpSession.getAttribute(attrName) : null;
        return object;
    }

    public static void removeObjectFromSession(final HttpServletRequest request, final String attrName) {
        final HttpSession httpSession = request.getSession(Boolean.FALSE);
        if (httpSession != null)
            httpSession.removeAttribute(attrName);
    }

    public static void invalidateSession(final HttpServletRequest request) {
        final HttpSession httpSession = request.getSession(Boolean.FALSE);
        if (httpSession != null)
            httpSession.invalidate();
    }
}
