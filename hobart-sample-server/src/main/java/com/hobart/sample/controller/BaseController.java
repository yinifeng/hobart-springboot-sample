package com.hobart.sample.controller;

import com.hobart.sample.core.dto.LoginAuthDto;
import com.hobart.sample.core.utils.ThreadLocalMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    protected LoginAuthDto getCurrentUser(){
        return (LoginAuthDto) ThreadLocalMap.get("accountid");
    }
}


