package com.hobart.sample.controller;

import com.hobart.sample.core.utils.ThreadLocalMap;

public abstract class BaseController {
    
    
    protected String getCurrent(){
        return (String) ThreadLocalMap.get("accountid");
    }
}


