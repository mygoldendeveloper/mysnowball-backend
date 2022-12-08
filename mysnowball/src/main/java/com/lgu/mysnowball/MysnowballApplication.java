package com.lgu.mysnowball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MysnowballApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysnowballApplication.class, args);
    }

}
