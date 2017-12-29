package com.vserdiuk.qr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by vserdiuk on 12/21/17.
 */

@SpringBootApplication
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
//@PropertySource("application.properties")
public class QrCodeGeneratorApp {
    public static void main(String[] args) {
        SpringApplication.run(QrCodeGeneratorApp.class, args);
    }
} 