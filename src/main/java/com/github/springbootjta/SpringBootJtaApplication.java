package com.github.springbootjta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class SpringBootJtaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJtaApplication.class, args);
    }

}
