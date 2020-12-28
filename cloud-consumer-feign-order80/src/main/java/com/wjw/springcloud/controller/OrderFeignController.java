package com.wjw.springcloud.controller;

import com.wjw.springcloud.entities.CommonResult;
import com.wjw.springcloud.entities.Payment;
import com.wjw.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020/12/28 0028
 *
 * @author weng
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentByid(@PathVariable("id") Long id){
        return  paymentFeignService.getPaymentByid(id);
    }


    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign-ribbon 客户端默认等待1S
        return paymentFeignService.paymentFeignTimeout();
    }


}
