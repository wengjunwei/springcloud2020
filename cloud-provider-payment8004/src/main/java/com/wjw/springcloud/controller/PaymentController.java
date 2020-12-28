package com.wjw.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created on 2020/12/27 0027
 *
 * @author weng
 */
@RestController
@Slf4j
public class PaymentController {

    @Value(value = "${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
