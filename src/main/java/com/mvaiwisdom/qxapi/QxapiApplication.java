package com.mvaiwisdom.qxapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling

public class QxapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(QxapiApplication.class, args);
    }



}
