package com.dascom.main.dao;

import com.dascom.main.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by jiazw on 4/29/2020.
 */
@Mapper
public interface PaymentDao {

    public long insertPayment(Payment payment);

    public Payment selectPaymentById(long id);


}
