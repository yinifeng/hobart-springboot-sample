package com.hobart.sample.service;

import com.hobart.sample.common.support.Service;
import com.hobart.sample.core.dto.LoginAuthDto;
import com.hobart.sample.domain.model.Employee;

public interface EmployeeService extends Service<Employee,String>{
    
    
    int insert(Employee employee);
    
    int addEmp(String name, Integer age, LoginAuthDto loginAuthDto)  throws Exception;
    
    Employee selectById(String id);
}
