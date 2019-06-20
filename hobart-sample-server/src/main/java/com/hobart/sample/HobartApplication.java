package com.hobart.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.hobart.sample.mapper")
//@ComponentScan(basePackageClasses={CoreConfig.class, CommonConfig.class})
public class HobartApplication {

    public static void main(String[] args) {
        SpringApplication.run(HobartApplication.class,args);
    }
}
