package com.zeus.core.filter;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ZeusLogFilter extends HttpServlet implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String URL = request.getRequestURI();
        Map<String,Object> map = getParameters(request);
        log.info("请求URL为：{}, 请求参数为：{}======================",  URL, JSON.toJSONString(map));
        filterChain.doFilter(servletRequest, servletResponse);
        long total = System.currentTimeMillis() - start;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        log.info("URL为：{}, 总共耗时：{}", URL, total);
        return;
    }

    public static Map<String,Object> getParameters(HttpServletRequest req){
        Map<String,Object> map=new HashMap<>();
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String key=names.nextElement(); //获取key值
            map.put(key, req.getParameter(key));    //获取value值
        }
        return map;
    }
}
