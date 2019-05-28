package com.btm.feignInterface;

import com.btm.commonmodul.model.NestedModel;
import com.btm.commonmodul.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Feign接口模板配置文件
 * @Author： BigTailMonkey
 * @Date： 2019-05-27
 * @Version： 1.0
 *
 * url： 读取配置文件中配置的服务端地址
 */
@FeignClient(name = "customer-service",url = "${gl.service.into.url}")
public interface DemoClient {

    /**
     * value: 服务端接口URI
     * method: 服务消费者调用服务提供者时的请求方式
     * @return 单个 简单 String类型
     */
    @RequestMapping(value = "/test/simpleStringWithNoParam",method = RequestMethod.GET)
    String simpleStringWithNoParam();

    /**
     * value: 服务端接口URI
     * method: 服务消费者调用服务提供者时的请求方式
     * @param name 单个 简单 String类型参数
     * @return 单个 简单 String类型
     */
    @RequestMapping(value = "/test/simpleStringWithOneParam",method = RequestMethod.GET)
    String simpleStringWithOneParam(@RequestParam("name") String name);

    /**
     * value: 服务端接口URI
     * method: 服务消费者调用服务提供者时的请求方式
     * @param name 多个 简单 参数
     * @return 单个 简单 String类型
     */
    @RequestMapping(value = "/test/simpleStringWithMultiParam",method = RequestMethod.GET)
    String simpleStringWithMultiParam(@RequestParam("name") String name,@RequestParam("id")int id);

    /**
     * 使用Feign调用接口且需要传递对象参数时，要使用Post请求方式
     * 并且服务提供者相应的接口的参数要使用@RequestBody注解进行修饰
     * value: 服务端接口URI
     * method: 服务消费者调用服务提供者时的请求方式
     * @param userModel 单个 对象类型参数
     * @return 单个 简单 String类型
     */
    @RequestMapping(value = "/test/simpleStringWithOneObject",method = RequestMethod.POST)
    String simpleStringWithOneObject( UserModel userModel);

    /**
     * 使用Feign调用接口且需要传递对象参数时，要使用Post请求方式
     * 并且服务提供者相应的接口的参数要使用@RequestBody注解进行修饰
     * value: 服务端接口URI
     * method: 服务消费者调用服务提供者时的请求方式
     * @param userModel 单个 简单 对象类型参数
     * @return 单个 简单 object类型
     */
    @RequestMapping(value = "/test/objectWithOneObject",method = RequestMethod.POST)
    UserModel objectWithOneObject(UserModel userModel);

    /**
     * 使用Feign调用接口且需要传递对象参数时，要使用Post请求方式
     * 并且服务提供者相应的接口的参数要使用@RequestBody注解进行修饰
     * value: 服务端接口URI
     * method: 服务消费者调用服务提供者时的请求方式
     * @param nestedModel 单个 嵌套 对象类型参数
     * @return 单个 简单 String字符串
     */
    @RequestMapping(value = "/test/simpleStringWithNestedObject",method = RequestMethod.POST)
    String objectWithNestedObject(NestedModel nestedModel);

    /**
     * 使用Feign调用接口且需要传递对象参数时，要使用Post请求方式
     * 并且服务提供者相应的接口的参数要使用@RequestBody注解进行修饰
     * value: 服务端接口URI
     * method: 服务消费者调用服务提供者时的请求方式
     * @param nestedModel 单个 嵌套 对象类型参数
     * @return 单个 嵌套 对象返回值
     */
    @RequestMapping(value = "/test/nestedObjectWithNestedObject",method = RequestMethod.POST)
    NestedModel nestedObjectWithNestedObject(NestedModel nestedModel);

    /**
     * 使用Feign调用接口且需要传递对象参数时，要使用Post请求方式
     * 并且服务提供者相应的接口的参数要使用@RequestBody注解进行修饰
     * value: 服务端接口URI
     * method: 服务消费者调用服务提供者时的请求方式
     * @param i 单个 简单 基本类型
     * @return 集合
     */
    @RequestMapping(value = "/test/listWithSimpleParam",method = RequestMethod.POST)
    List<NestedModel> listWithSimpleParam(int i);
}
