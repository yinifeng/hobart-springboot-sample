package com.hobart.sample.service;

import com.hobart.sample.common.support.Service;
import com.hobart.sample.domain.model.Employee;

public interface EmployeeService extends Service<Employee>{
    
    
    int insert(Employee employee);
    
}
