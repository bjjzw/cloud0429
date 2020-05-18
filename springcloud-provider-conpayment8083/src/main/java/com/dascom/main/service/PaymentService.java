package com.dascom.main.service;

import com.dascom.main.entity.Payment;

public interface PaymentService {

    public long insertPayment(Payment payment);

    public Payment selectPaymentById(long id);
}
