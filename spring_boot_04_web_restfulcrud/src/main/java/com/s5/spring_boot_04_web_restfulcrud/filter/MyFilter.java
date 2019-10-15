package com.s5.spring_boot_04_web_restfulcrud.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: Aresong
 * @Date: 2019/4/26 23:18
 * @Version 1.0
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process……");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
