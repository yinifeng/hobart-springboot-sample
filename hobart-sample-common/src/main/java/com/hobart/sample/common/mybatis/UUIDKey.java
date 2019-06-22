package com.hobart.sample.common.mybatis;

import com.hobart.sample.common.support.SpringContextHolder;
import com.hobart.sample.common.support.UUIDGenetor;
import tk.mybatis.mapper.genid.GenId;

public class UUIDKey implements GenId<String>{
    
    @Override
    public String genId(String table, String column) {
        //return UUID.randomUUID().toString().replaceAll("-", "");
        UUIDGenetor uUIDGenetor = (UUIDGenetor) SpringContextHolder.getBean("uUIDGenetor");
        return uUIDGenetor.key();
    }
}
