package com.hobart.sample.service;

import com.hobart.sample.domain.model.Employee;
import com.hobart.sample.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void batchInsert() {
        Date now = new Date();
        Employee e1=new Employee();
        e1.setAge(21);
        e1.setName("tom");
        e1.setCreateTime(now);
        e1.setUpdateTime(now);
        e1.setCreator("hb");
        e1.setUpdator("hb");

        Employee e2=new Employee();
        e2.setAge(26);
        e2.setName("marry");
        e2.setCreateTime(now);
        e2.setUpdateTime(now);
        e2.setCreator("hb");
        e2.setUpdator("hb");

        List<Employee> employees=new ArrayList<>();
        employees.add(e1);
        employees.add(e2);

        int result = this.employeeService.batchSave(employees);
        employees.forEach(e ->{
            System.out.println("------------->"+e.getId());
        });
        
    }
    
    @Test
    public void insertEmp(){
        Date now = new Date();
        Employee e1=new Employee();
        e1.setAge(20);
        e1.setName("jack22222");
        e1.setCreateTime(now);
        e1.setUpdateTime(now);
        e1.setCreator("hb");
        e1.setUpdator("hb");
        
        this.employeeService.insert(e1);
        System.out.println("==============>"+e1.getId());
    }
    
    @Test
    public void testBatchDelete(){
        int result = this.employeeMapper.deleteByIdList(Arrays.asList("4ebf36e978444e1c8fb5daa443e9cd33", "f772fbb05fcb4354bfea7be3ab74b788"));
        System.out.println("=====>"+result);
    }
    
    @Test
    public void testSelectByIds(){
        List<Employee> employees = this.employeeMapper.selectByIdList(Arrays.asList("1742877cf26e4945ad0a0c86fc024620", "1acb1756721d464e8c9526a7a3d6cbb5"));
        employees.forEach(e->{
            System.out.println(e.getId()+"<========>"+e.getName());
        });
    }
    
}
