package com.hobart.sample.controller;

import com.hobart.sample.common.annotation.ValidateAnnotation;
import com.hobart.sample.core.dto.LoginAuthDto;
import com.hobart.sample.core.utils.ThreadLocalMap;
import com.hobart.sample.core.wrapper.WrapMapper;
import com.hobart.sample.core.wrapper.Wrapper;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);
    
    
    @ValidateAnnotation
    @GetMapping("/get")
    public Wrapper<Student> getStudent(){
        LoginAuthDto loginAuthDto = (LoginAuthDto)ThreadLocalMap.get("accountid");
        Student student = new Student();
        student.setId(1);
        student.setAge(21);
        student.setName("tom");
        student.setEmail("tom@qq.com");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId()+"=========跳线程=========="+ThreadLocalMap.get("accountid"));
            }
        }).start();
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("方法执行完成......"+loginAuthDto.getUserAccount());
        return WrapMapper.ok(student);
    }

    /**
     *  注解 @ValidateAnnotation  配合@Valid  BindingResult result
     * @param student
     * @return
     */
    //@ValidateAnnotation
    @PostMapping("/add")
    public Wrapper<Student> addStudent(@Valid @RequestBody Student student/*,BindingResult result*/){
        if (student.getAge() >= 100) {
            throw new IllegalArgumentException("年龄为100");
        }
        System.out.println(student.name);
        return WrapMapper.ok(student);
    }
    
    
    public static class Student{
        private Integer id;
        @Length(max = 4, message = "{student.name.length}")
        private String name;
        
        private Integer age;
        
        private String email;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
