package com.dascom.main.controller;

import cn.hutool.Hutool;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.dascom.main.entity.Payment;
import com.dascom.main.response.BaseResponse;
import com.dascom.main.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@DefaultProperties(defaultFallback = "defaultFallback")
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

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


    @HystrixCommand(fallbackMethod ="getPaymentByIdFallback" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000"),//默认1s。方法处理时间不能超过5s
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),             //断路器可使用
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//时间段内的请求失败个数达到此数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//短路多久以后开始尝试是否恢复，默认5s
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//出错百分比阈值，当达到此阈值后，开始短路。默认50%
    })
    @GetMapping("/hystrix/ok/{id}")
    public String getPaymentByIdOk(@PathVariable("id") long id) {
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


    @HystrixCommand(fallbackMethod ="getPaymentByIdFallback" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000"),//默认1s。方法处理时间不能超过5s
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),             //断路器可使用
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//时间段内的请求失败个数达到此数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//短路多久以后开始尝试是否恢复，默认5s
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//出错百分比阈值，当达到此阈值后，开始短路。默认50%
    })
    @GetMapping("/hystrix/{id}")
    public String getPaymentByIdTwo(@PathVariable("id") long id) {
        Payment payment = paymentService.selectPaymentById(id);

        if (id<0){

            int a =10/0;
        }
        BaseResponse<Payment> objectBaseResponse = new BaseResponse<>();
        ArrayList<Payment> data = new ArrayList<>();
        data.add(payment);
        objectBaseResponse.setCode(200);
        objectBaseResponse.setMessage("success");
        objectBaseResponse.setData(data);

        String paymentInfo = JSON.toJSONString(objectBaseResponse);
        return paymentInfo;
    }

    //查看服务降级配置参数
    //https://github.com/Netflix/Hystrix/wiki/Configuration

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

    public String getPaymentByIdFallback(long id) {

        BaseResponse<Payment> objectBaseResponse = new BaseResponse<>();
        ArrayList<Payment> data = new ArrayList<>();
        objectBaseResponse.setCode(404);
        objectBaseResponse.setMessage("fail");
        objectBaseResponse.setData(data);

        String paymentInfo = JSON.toJSONString(objectBaseResponse);
        return paymentInfo;
    }


    //全局服务降级处理
    public String defaultFallback(){


        return  "服务繁忙请稍后再试";
    }
}
