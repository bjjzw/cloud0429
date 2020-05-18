package com.dascom.main.controller;

import com.dascom.main.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
@Slf4j
@RestController()
@RequestMapping("/order")
public class OrderController {
    private static  String url="http://provider-conpayment8001";
    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/insert")
    public String createPayment(@RequestBody Payment payment){

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url + "/payment/insert", payment, String.class);

        String body = stringResponseEntity.getBody();


        return  body;
    }



    @GetMapping ("/payment/{id}")
    public String getPayment( @PathVariable String id){

        ResponseEntity<String> stringResponseEntity = restTemplate.getForEntity(url + "/payment/"+id, String.class);

        String body = stringResponseEntity.getBody();
        log.info("获取到商品信息"+body);

        return  body;
    }
}
