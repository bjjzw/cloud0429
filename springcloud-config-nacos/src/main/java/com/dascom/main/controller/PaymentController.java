package com.dascom.main.controller;

import com.alibaba.fastjson.JSON;
import com.dascom.main.entity.Payment;
import com.dascom.main.response.BaseResponse;
import com.dascom.main.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/payment")
@RefreshScope
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${spring.version}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigVersion(){

        return  configInfo;
    }
    @GetMapping("/{id}")
    public String getPaymentById(@PathVariable("id") long id) {
        Payment payment = paymentService.selectPaymentById(id);

        BaseResponse<Payment> objectBaseResponse = new BaseResponse<>();
        ArrayList<Payment> data = new ArrayList<>();
        data.add(payment);
        objectBaseResponse.setCode(200);
        objectBaseResponse.setMessage("success");
        objectBaseResponse.setData(data);

        String paymentInfo = JSON.toJSONString(objectBaseResponse);
        return paymentInfo;
    }

    @PostMapping("/insert")
    public String createPayment(@RequestBody Payment payment) {


        long id = paymentService.insertPayment(payment);

        BaseResponse<Payment> objectBaseResponse = new BaseResponse<>();
        ArrayList<Payment> data = new ArrayList<>();
        objectBaseResponse.setCode(200);
        objectBaseResponse.setMessage("success");
        String paymentInfo = JSON.toJSONString(objectBaseResponse);
        return paymentInfo;
    }


}
