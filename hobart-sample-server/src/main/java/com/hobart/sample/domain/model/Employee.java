package com.hobart.sample.domain.model;

import com.hobart.sample.common.mybatis.BaseEntity;

import javax.persistence.*;

@Table(name = "t_hobart_employee")
public class Employee extends BaseEntity{
    
    private String name;
    
    private Integer age;

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
    
    
}
