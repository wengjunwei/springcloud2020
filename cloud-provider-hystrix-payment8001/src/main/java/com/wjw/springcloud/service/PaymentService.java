package com.wjw.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created on 2020/12/28 0028
 *
 * @author weng
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池"+Thread.currentThread().getName()+"  paymentInfo_OK,id："+id+"正常访问!";
    }


    public String paymentInfo_Timeout(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_Timeout，id:"+id+"耗时(秒)"+timeNumber;
    }

}
