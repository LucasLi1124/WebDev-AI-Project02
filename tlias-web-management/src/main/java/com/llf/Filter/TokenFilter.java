package com.llf.Filter;

import com.llf.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取请求路径
        String reqiestURI = request.getRequestURI();

        //判断是否登录请求  如果路径中包含 /login，说明是登录操作，放行
        if (reqiestURI.contains("/login")) {
            log.info("登录请求，放行");
            filterChain.doFilter(request, response);
            return;
        }

        //获取请求头中的token
        String token = request.getHeader("token");


        //判断token是否存在，如果不存在，说明用户没有登录，返回错误信息 401
        if (token == null || token.isEmpty()) {
            log.info("令牌为空，响应401");
            response.setStatus(401);
            return;
        }

        //如果token存在，校验令牌，如果校验失败，返回错误信息 401
        try {
            JwtUtils.parseToken(token);

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.info("令牌校验失败，响应401");
            response.setStatus(401);
        }


        //校验通过 放行
        log.info("令牌校验通过，放行");
        filterChain.doFilter(request, response);
    }
}
