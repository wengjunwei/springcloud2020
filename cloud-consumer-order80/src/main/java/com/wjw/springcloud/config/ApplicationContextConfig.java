package com.wjw.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 2020/12/25 0025
 *
 * @author weng
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced//开启负载均衡的功能
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
