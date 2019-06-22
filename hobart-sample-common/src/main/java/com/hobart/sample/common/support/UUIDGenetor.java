package com.hobart.sample.common.support;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("uUIDGenetor")
public class UUIDGenetor {
    
    public String key(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
