package com.llf.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
//@WebFilter(urlPatterns = "*") // 拦截所有请求
@Slf4j
public class DemoFilter implements Filter {

    //初始化方法，web服务器启动的时候执行，只执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器初始化");
    }
    // 过滤方法，在过滤器拦截的请求处理之前执行，执行多次，可以做权限验证，日志记录等
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤器开始工作");
        // 放行，让请求继续处理
        filterChain.doFilter(servletRequest,servletResponse);

    }
    //销毁方法，在web服务器关闭的时候执行
    @Override
    public void destroy() {
        log.info("过滤器销毁");

    }
}
