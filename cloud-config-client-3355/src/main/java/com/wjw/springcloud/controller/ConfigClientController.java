package com.wjw.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2021/1/8 0008
 *
 * @author weng
 */
@RestController
@RefreshScope
public class ConfigClientController {

    // 因为config仓库以rest形式暴露，所以所有客户端都可以通过config服务端访问到github上对应的文件信息

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/configInfo")
    public String getConfiginfo(){
        return  configInfo;
    }

}
