package com.hobart.sample.service;

import com.hobart.sample.HobartApplication;
import com.hobart.sample.domain.model.Employee;
import com.hobart.sample.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest(classes = HobartApplication.class)
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    @Rollback
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
            System.out.println(result+"------------->"+e);
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
        System.out.println("==============>"+e1);
    }
    
    @Test
    public void testBatchDelete(){
        int result = this.employeeMapper.deleteByIdList(Arrays.asList("5ad0bead51d84d2f9245165cf2c10e52", "8bd1280407554b71bbed4553d4b49ad8"));
        System.out.println("=====>"+result);
    }
    
    @Test
    public void testSelectByIds(){
        List<Employee> employees = this.employeeMapper.selectByIdList(Arrays.asList("5ad0bead51d84d2f9245165cf2c10e52", "8bd1280407554b71bbed4553d4b49ad8"));
        employees.forEach(e->{
            System.out.println(e.getId()+"<========>"+e);
        });
    }
    
    @Test
    public void testSelectById(){
        Employee employee = this.employeeService.selectById("0fb6ed612202470f9a03e956fb4c3921");
        System.out.println(employee);
    }
    
}
