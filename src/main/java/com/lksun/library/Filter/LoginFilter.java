package com.lksun.library.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "loginFilter", urlPatterns = "/login")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        System.out.println(request.getRequestURI());
        System.out.println(user);
        System.out.println("----------");
        if (user == null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            response.sendRedirect("/");
        }

    }


    @Override
    public void destroy() {

    }


}
