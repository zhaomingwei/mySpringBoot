package com.zw.cn.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Date;

@SpringBootApplication
public class MyspringbootApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
//        SpringApplication.run(MyspringbootApplication.class, args);
        System.out.println((new Date()).getTime());
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MyspringbootApplication.class);
    }
}
