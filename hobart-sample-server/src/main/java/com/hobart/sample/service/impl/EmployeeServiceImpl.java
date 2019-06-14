package com.hobart.sample.service.impl;

import com.hobart.sample.common.support.BaseService;
import com.hobart.sample.domain.model.Employee;
import com.hobart.sample.mapper.EmployeeMapper;
import com.hobart.sample.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl extends BaseService<EmployeeMapper,Employee> implements EmployeeService{
    
    
    @Override
    public int insert(Employee employee) {
        int result = this.save(employee);
        int i = 1 / 0;
        return result;
    }
}
