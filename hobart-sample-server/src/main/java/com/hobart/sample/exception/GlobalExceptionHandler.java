/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：GlobalExceptionHandler.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.hobart.sample.exception;


import com.hobart.sample.core.wrapper.WrapMapper;
import com.hobart.sample.core.wrapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * 全局的的异常拦截器
 *
 * @author paascloud.net @gmail.com
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	private static Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
	 * 参数非法异常.
	 *
	 * @param e the e
	 *
	 * @return the wrapper
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Wrapper handleIllegalArgumentException(HttpServletRequest request,IllegalArgumentException e) {
		//logger.error("参数非法异常={}", e.getMessage(), e);
		logger.warn("参数非法异常={}", e.getMessage());
		return WrapMapper.wrap(91000, e.getMessage());
	}

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Wrapper handleMethodArgumentNotValidException(
            HttpServletRequest request, MethodArgumentNotValidException ex
    ) {
        final Optional<ObjectError> firstError = ex.getBindingResult().getAllErrors().stream().findFirst();
        if (firstError.isPresent()) {
            //final String firstErrorMessage = firstError.get().getDefaultMessage();
            ObjectError objectError = firstError.get();
            final String firstErrorMessage = objectError.getDefaultMessage();
            String objectName = objectError.getObjectName();
            return WrapMapper.wrap(91000, firstErrorMessage);
        }
        return WrapMapper.wrap(91000, "参数错误");
    }
}
