package com.dascom.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by jiazw on 4/29/2020.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPaymentMain8081 {


    public static void main(String[] args) {
        SpringApplication.run(ConsulPaymentMain8081.class);


    }

}
