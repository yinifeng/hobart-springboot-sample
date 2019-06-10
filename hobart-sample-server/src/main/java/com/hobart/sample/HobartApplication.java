package com.hobart.sample;

import com.hobart.sample.common.CommonConfig;
import com.hobart.sample.core.CoreConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackageClasses={CoreConfig.class, CommonConfig.class})
public class HobartApplication {

    public static void main(String[] args) {
        SpringApplication.run(HobartApplication.class,args);
    }
}
