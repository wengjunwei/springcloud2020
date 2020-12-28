package com.wjw.springcloud.controller;

import com.wjw.springcloud.entities.CommonResult;
import com.wjw.springcloud.entities.Payment;
import com.wjw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020/12/25 0025
 *
 * @author weng
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentByid(@PathVariable("id") Long id){
        Payment pa = paymentService.getPaymentById(id);

        log.info("*****输入结果："+pa);

        if (pa!=null) {
             return new CommonResult(200,"查询成功,serverPort:"+serverPort,pa);
        }else{
             return new CommonResult(400,"查询失败",null);
        }

    }


    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);

        log.info("*****输入结果："+result+"sdsdd");

        if (result>0) {
            return new CommonResult(200,"插入成功,serverPort:"+serverPort,result);
        }else{
            return new CommonResult(400,"插入失败",null);
        }

    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();

        for (String s : services){
            log.info("**********element:"+s);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance si : instances){
            log.info(si.getServiceId()+"\t"+si.getHost()+"\t"+si.getPort()+"\t"+si.getUri());
        }
        return this.discoveryClient;
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
