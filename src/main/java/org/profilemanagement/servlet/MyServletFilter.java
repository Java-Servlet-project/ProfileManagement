package org.profilemanagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/welcome")
public class MyServletFilter implements Filter {
    
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) 
            throws IOException, ServletException {
        final PrintWriter writer = response.getWriter();
        writer.print("<h2>Filter invoked before welcome servlet</h2>");
        chain.doFilter(request, response);
        writer.print("<h2>Filter invoked after welcome servlet</h2>");
    }

}
