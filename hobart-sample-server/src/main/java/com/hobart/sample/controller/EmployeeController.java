package com.hobart.sample.controller;

import com.hobart.sample.core.dto.LoginAuthDto;
import com.hobart.sample.core.wrapper.WrapMapper;
import com.hobart.sample.core.wrapper.Wrapper;
import com.hobart.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController extends BaseController{
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/add")
    public Wrapper addEmp(String name,Integer age){
        LoginAuthDto loginAuthDto = this.getCurrentUser();
        this.logger.info("请求参数name={},age={}",name,age);
        //employeeService.addEmp(name, age, loginAuthDto);
        return WrapMapper.ok(employeeService.addEmp(name, age, loginAuthDto));
    }
}
