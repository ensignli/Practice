package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync(proxyTargetClass = true)
@SpringBootApplication
@ServletComponentScan
public class CfdApplication {

    public static void main(String[] args) {
        SpringApplication.run(CfdApplication.class, args);
    }

}
