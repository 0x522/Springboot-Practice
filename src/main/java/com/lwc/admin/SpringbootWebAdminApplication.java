package com.lwc.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.lang.Nullable;


@ServletComponentScan("com.lwc.admin")
@SpringBootApplication
public class SpringbootWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebAdminApplication.class, args);
    }

}
