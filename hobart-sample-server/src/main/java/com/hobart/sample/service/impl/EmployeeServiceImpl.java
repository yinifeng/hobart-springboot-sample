package com.hobart.sample.service.impl;

import com.hobart.sample.common.support.BaseService;
import com.hobart.sample.core.dto.LoginAuthDto;
import com.hobart.sample.domain.model.Employee;
import com.hobart.sample.mapper.EmployeeMapper;
import com.hobart.sample.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl extends BaseService<EmployeeMapper, Employee, String> implements EmployeeService {


    //@Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(Employee employee) {
        int result = this.save(employee);
        //int i = 1 / 0;
        this.logger.info("EmployeeServiceImpl==={}==>{}", result, employee);
        return result;
    }
    
    @Override
    //@Transactional(rollbackFor=Exception.class)
    public int addEmp(String name, Integer age, LoginAuthDto loginAuthDto) throws Exception {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        employee.setUpdateInfo(loginAuthDto);
        this.logger.info("{}执行插入操作.....", this.getClass());
        int result = this.save(employee);
        this.addEmp2(employee);
        //int i=1/0;
        if (true) {
            //throw new RuntimeException("测试回滚事务");
            throw new Exception("测试回滚事务");
        }
        return result;
    }
    
    private void addEmp2(Employee employee){
        Employee employee2 = new Employee();
        employee2.setAge(employee.getAge());
        employee2.setName(employee.getName()+"8888");
        this.save(employee2);
    }

    @Override
    public Employee selectById(String id) {
        return this.mapper.selectById(id);
    }
}
