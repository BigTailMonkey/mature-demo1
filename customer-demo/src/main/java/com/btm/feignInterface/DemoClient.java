package com.btm.feignInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "gl-into-service",url = "${gl.service.into.url}")
public interface DemoClient {

    @RequestMapping(value = "/test/test",method = RequestMethod.GET)
    String test();

}
