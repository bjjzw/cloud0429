package com.dascom.main.service.fallback;

import com.dascom.main.entity.Payment;
import com.dascom.main.service.PaymentService;

public class PaymentServiceFallback implements PaymentService {

    @Override
    public String getPaymentById(long id) {
        return "error  please try again!";
    }

    @Override
    public String createPayment(Payment payment) {
        return null;
    }

    @Override
    public String getPaymentByIdTwo(long id) {
        return null;
    }
}
