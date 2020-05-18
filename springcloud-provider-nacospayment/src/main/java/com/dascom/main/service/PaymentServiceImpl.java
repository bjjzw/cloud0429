package com.dascom.main.service;

import com.dascom.main.dao.PaymentDao;
import com.dascom.main.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public long insertPayment(Payment payment) {


        return paymentDao.insertPayment(payment);
    }

    @Override
    public Payment selectPaymentById(long id) {

        return paymentDao.selectPaymentById(id);
    }
}
