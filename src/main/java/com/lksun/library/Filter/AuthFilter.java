package com.lksun.library.Filter;

import org.springframework.core.annotation.Order;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Order(1)  // 表示过滤器的排序 数字越小，优先级越高  如果不设置则按照过滤器名称字母排序
@WebFilter(filterName = "AdminAuthFilter", urlPatterns = {"/*"})

public class AuthFilter implements Filter {

    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/login", "/register","/druid")));
    private static final Set<String> FUZZY_ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/login/**","/static/**","/register/**","/druid/**")));

    /**
     * 可以初始化Filter在web.xml里面配置的初始化参数
     * filter对象只会创建一次，init方法也只会执行一次。
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 主要的业务代码编写方法
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI();
        if(!(ALLOWED_PATHS.contains(path) || this.allowed(path))){
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if (user == null){
                // 需要登录
                response.sendRedirect("/login");
            }else{
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    /**
     * 在销毁Filter时自动调用。
     */
    @Override
    public void destroy() {

    }

    private Boolean allowed(String path){
        Boolean result = null;
        String[] split = path.split("/");
        try {
            result = FUZZY_ALLOWED_PATHS.contains("/"+split[1]+"/**");
        }catch (Exception e){
            result = false;
        }
        return result;
    }
}
