package com.dascom.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientMain {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain.class, args);
    }
}
