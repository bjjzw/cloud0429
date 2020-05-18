package com.dascom.main.controller;

import com.dascom.main.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/feign")
@RestController
public class OpenFeignController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/{id}")
    public String getPaymentById(@PathVariable("id") long id){


        String paymentById = paymentService.getPaymentById(id);

        return  paymentById;

    }

    @GetMapping("/hystrix/payment/{id}")
    public String getPaymentByIdTwo(@PathVariable("id") long id){


        String paymentById = paymentService.getPaymentByIdTwo(id);

        return  paymentById;

    }
}
