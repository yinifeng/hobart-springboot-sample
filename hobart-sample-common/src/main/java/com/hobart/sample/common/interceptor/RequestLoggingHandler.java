package com.hobart.sample.common.interceptor;

import com.hobart.sample.common.servlet.BodyCacheHttpServletRequestWrapper;
import com.hobart.sample.common.servlet.BodyCacheHttpServletResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestLoggingHandler implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingHandler.class);


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String method = request.getMethod();
        if (HttpMethod.POST.matches(method) || HttpMethod.PATCH.matches(method) || HttpMethod.PUT.matches(method)) {
            if (request instanceof BodyCacheHttpServletRequestWrapper) {
                BodyCacheHttpServletRequestWrapper requestWrapper = ((BodyCacheHttpServletRequestWrapper) request);
                logger.info("[请求] - [{}]", new String(requestWrapper.getBody()));
            }
        }
        return true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }


    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        final String method = request.getMethod();
        if (HttpMethod.POST.matches(method) || HttpMethod.PATCH.matches(method) || HttpMethod.PUT.matches(method)) {
            if (response instanceof BodyCacheHttpServletResponseWrapper) {
                BodyCacheHttpServletResponseWrapper responseWrapper = ((BodyCacheHttpServletResponseWrapper) response);
                logger.info("[请求] - [{}]", new String(responseWrapper.getBody()));
            }
        }
    }

}
