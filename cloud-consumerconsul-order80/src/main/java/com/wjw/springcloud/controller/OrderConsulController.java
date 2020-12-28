package com.wjw.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 2020/12/27 0027
 *
 * @author weng
 */
@RestController
@Slf4j
public class OrderConsulController {

    private static final String INVOK_URL="http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String  paymentInfo(){
        String result = restTemplate.getForObject(INVOK_URL + "/payment/consul", String.class);
        return  result;
    }

}
