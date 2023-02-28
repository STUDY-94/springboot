package com.spring.boot.springboot.filter.xss.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class XssProtectFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        XssRequestWrapper wrappedRequest = new XssRequestWrapper((HttpServletRequest) request);
        String body = IOUtils.toString(wrappedRequest.getReader());

        if (!StringUtils.isBlank(body)) {
            Map<String, Object> oldJsonObject = new ObjectMapper().readValue(body, HashMap.class);
            Map<String, Object> newJsonObject = new HashMap<>();
            oldJsonObject.forEach((key, value) -> newJsonObject.put(key, XssUtils.charEscape(value.toString())));
            wrappedRequest.resetInputStream(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(newJsonObject).getBytes());
        }

        chain.doFilter(wrappedRequest, response);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
