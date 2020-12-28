package com.wjw.springcloud.service;

import com.wjw.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Created on 2020/12/25 0025
 *
 * @author weng
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
