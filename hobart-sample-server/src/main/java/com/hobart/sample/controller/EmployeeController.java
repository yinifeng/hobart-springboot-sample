package com.hobart.sample.controller;

import com.hobart.sample.core.dto.LoginAuthDto;
import com.hobart.sample.core.utils.JacksonUtil;
import com.hobart.sample.core.wrapper.WrapMapper;
import com.hobart.sample.core.wrapper.Wrapper;
import com.hobart.sample.domain.enums.FreeMarkTemplateEnum;
import com.hobart.sample.service.EmployeeService;
import com.hobart.sample.service.FreeMarkerService;
import org.omg.CORBA.DATA_CONVERSION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmployeeController extends BaseController{
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private FreeMarkerService freeMarkerService;
    
    @GetMapping("/add")
    public Wrapper addEmp(String name,Integer age){
        LoginAuthDto loginAuthDto = this.getCurrentUser();
        this.logger.info("请求参数name={},age={}",name,age);
        //employeeService.addEmp(name, age, loginAuthDto);
        return WrapMapper.ok(employeeService.addEmp(name, age, loginAuthDto));
    }

    @GetMapping("/get")
    public Wrapper addEmp() throws Exception{
        LoginAuthDto loginAuthDto = this.getCurrentUser();
        //this.logger.info("请求参数name={},age={}",name,age);
        //employeeService.addEmp(name, age, loginAuthDto);
        Map<String,Object> map = new HashMap<>();
        map.put("loginName", loginAuthDto.getUserAccount());
        map.put("dateTime", new Date());
        String text = this.freeMarkerService.getTemplate(map, FreeMarkTemplateEnum.ACTIVE_USER_SUCCESS.getLocation());
        
        Map<String,String> dataMap=new HashMap<>();
        dataMap.put("tilte", "学习模板");
        dataMap.put("msg", text);
        
        this.logger.info("发送信息={}", JacksonUtil.toJson(dataMap));
        return WrapMapper.ok(dataMap);
    }
}
