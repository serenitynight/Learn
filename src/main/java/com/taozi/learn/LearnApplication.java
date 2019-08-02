package com.taozi.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("com.taozi.learn.mapper")
public class LearnApplication {

    // 启动spring boot应用
    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

}
