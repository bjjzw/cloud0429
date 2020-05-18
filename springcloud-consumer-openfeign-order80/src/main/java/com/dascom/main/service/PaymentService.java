package com.dascom.main.service;

import com.alibaba.fastjson.JSON;
import com.dascom.main.entity.Payment;
import com.dascom.main.response.BaseResponse;
import com.dascom.main.service.fallback.PaymentServiceFallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Component
@FeignClient(value = "provider-payment8001",fallback = PaymentServiceFallback.class)
public interface PaymentService {


    @GetMapping(value="/payment/{id}")
    public String getPaymentById(@PathVariable("id") long id);

    @PostMapping(value="/payment/insert")
    public String createPayment(@RequestBody Payment payment);


    @GetMapping("/payment/hystrix/{id}")
    public String getPaymentByIdTwo(@PathVariable("id") long id);

}
