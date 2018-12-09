package com.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.test"})
@MapperScan("com.test.dao")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
