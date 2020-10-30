package com.lazyi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lazyi.mapper")
public class YqmApplication {

    public static void main(String[] args) {
        SpringApplication.run(YqmApplication.class, args);
    }

}
