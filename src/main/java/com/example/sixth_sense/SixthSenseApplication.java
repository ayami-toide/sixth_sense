package com.example.sixth_sense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SixthSenseApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SixthSenseApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SixthSenseApplication.class);
    }
}
