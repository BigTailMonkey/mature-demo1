package com.btm.controller;

import com.btm.feignInterface.DemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用Feign调用远端服务接口demo
 * @Author： BigTailMonkey
 * @Date： 2019-05-27
 * @Version： 1.0
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoClient demoClient;

    /**
     * 无参数
     * GET请求方式
     * 简单String字符串类型返回值
     * @return
     */
    @GetMapping("returnStringByFeign")
    public String returnStringByFeign(){
        return demoClient.test();
    }
}
