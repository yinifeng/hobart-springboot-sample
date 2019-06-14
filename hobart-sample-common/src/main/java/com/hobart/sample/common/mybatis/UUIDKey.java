package com.hobart.sample.common.mybatis;

import tk.mybatis.mapper.genid.GenId;

import java.util.UUID;

public class UUIDKey implements GenId<String>{
    
    @Override
    public String genId(String table, String column) {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
