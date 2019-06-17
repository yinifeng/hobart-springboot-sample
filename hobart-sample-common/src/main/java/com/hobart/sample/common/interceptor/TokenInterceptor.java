package com.hobart.sample.common.interceptor;

import com.hobart.sample.core.dto.LoginAuthDto;
import com.hobart.sample.core.utils.ThreadLocalMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class TokenInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);
    public static final String TOKEN_KEY="accountid";


    /**
     * 目标方法执行之前
     * 
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("1..1....preHandle.........");
        String accountid = request.getHeader(TOKEN_KEY);
        LoginAuthDto user=new LoginAuthDto();
        user.setUserAccount(accountid);
        
        ThreadLocalMap.put(TOKEN_KEY, user);
        Enumeration<String> headerNames = request.getHeaderNames();
        logger.info("====>"+headerNames);
        logger.info("1..2....preHandle........."+accountid);
        return true;
    }

    /**
     * 目标方法执行之后 
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        LoginAuthDto loginAuthDto = (LoginAuthDto)ThreadLocalMap.get(TOKEN_KEY);
        logger.info("2.......postHandle........"+loginAuthDto.getUserAccount());
    }

    /**
     * posthandle 执行之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        LoginAuthDto loginAuthDto = (LoginAuthDto)ThreadLocalMap.get(TOKEN_KEY);
        logger.info("3.......afterCompletion........"+loginAuthDto.getUserAccount());
        ThreadLocalMap.remove(TOKEN_KEY);
    }
}
