package com.hobart.sample.controller;

import com.hobart.sample.core.wrapper.WrapMapper;
import com.hobart.sample.core.wrapper.Wrapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class TestController {
    
    @GetMapping("/get")
    @ResponseBody
    public Wrapper<Student> getStudent(){
        Student student = new Student();
        student.setId(1);
        student.setAge(21);
        student.setName("tom");
        student.setEmail("tom@qq.com");
        return WrapMapper.ok(student);
    }
    
    @PostMapping("/add")
    public Wrapper<Student> addStudent(@RequestBody Student student){
        return WrapMapper.ok(student);
    }
    
    
    public static class Student{
        private Integer id;
        
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
