package com.hobart.sample.mapper;

import com.hobart.sample.common.mybatis.MyMapper;
import com.hobart.sample.domain.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper extends MyMapper<Employee>{
}
