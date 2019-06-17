package com.hobart.sample.common.mybatis;

import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;


/**
 * MySqlMapper 自增序列的批量插入操作
 * 
 * 
 * @param <T>
 */
public interface MyMapper<T,PK> extends 
        Mapper<T>/*,MySqlMapper<T>*/
        , InsertListMapper<T>
        , IdListMapper<T, PK> {

}
