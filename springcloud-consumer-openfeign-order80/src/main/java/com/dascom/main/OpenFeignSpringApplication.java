package com.dascom.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients //扫描使用了feignClient注解的接口
@EnableDiscoveryClient
public class OpenFeignSpringApplication {


    public static void main(String[] args) {

        SpringApplication.run(OpenFeignSpringApplication.class, args);
    }
}
