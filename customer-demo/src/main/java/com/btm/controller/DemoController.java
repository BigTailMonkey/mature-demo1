package com.btm.controller;

import com.btm.commonmodul.model.CarModel;
import com.btm.commonmodul.model.NestedModel;
import com.btm.commonmodul.model.UserModel;
import com.btm.feignInterface.DemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
        return demoClient.simpleStringWithNoParam();
    }

    /**
     * 有参数   单个 String类型 参数
     * Get请求方式
     * @param name
     * @return
     */
    @GetMapping("returnStringByFeignWithOneParam")
    public String returnStringByFeignWithOneParam(String name){
        return demoClient.simpleStringWithOneParam(name);
    }

    /**
     * 有参数   多个 基本类型、String类型 参数
     * Get请求方式
     * @param name
     * @return 单个 简单 String类型
     */
    @GetMapping("returnStringByFeignWithMultiParam")
    public String returnStringByFeignWithMultiParam(String name,int id){
        return demoClient.simpleStringWithMultiParam(name,id);
    }

    /**
     * 有参数  单个 对象 参数
     * Post请求方式
     * @return 单个 简单 String类型
     */
    @GetMapping("returnStringByFeignWithOneObject")
    public String returnStringByFeignWithOneObject(){
        UserModel userModel = new UserModel();
        userModel.setName("BigTailMonkey");
        userModel.setAge(18);
        userModel.setSex("man");
        return demoClient.simpleStringWithOneObject(userModel);
    }

    /**
     * 有参数  单个 对象 参数
     * Post请求方式
     * @return 单个 简单 String类型
     */
    @GetMapping("objectByFeignWithOneObject")
    public String objectByFeignWithOneObject(){
        UserModel userModel = new UserModel();
        userModel.setName("BigTailMonkey");
        userModel.setAge(18);
        userModel.setSex("man");
        return "One object return : "+demoClient.objectWithOneObject(userModel).toString();
    }

    /**
     * 有参数 单个 嵌套对象 参数
     * Post请求方式
     * @return 单个 简单 String数据类型
     */
    @GetMapping("objectByFeignWithNestedObject")
    public String objectByFeignWithnestedObject(){
        UserModel userModel = new UserModel();
        userModel.setName("BigTailMonkey");
        userModel.setAge(18);
        userModel.setSex("man");
        CarModel carModel = new CarModel();
        carModel.setBrand("benz");
        carModel.setName("2000");
        NestedModel nestedModel = new NestedModel();
        nestedModel.setCarModel(carModel);
        nestedModel.setUserModel(userModel);
        nestedModel.setVersion(1.0f);
        return "Nested object return : "+demoClient.objectWithNestedObject(nestedModel);
    }

    /**
     * 有参数 单个 嵌套对象 参数
     * Post请求方式
     * @return 单个 嵌套 对象类型
     */
    @GetMapping("nestedObjectWithNestedObject")
    public String nestedObjectWithNestedObject(){
        UserModel userModel = new UserModel();
        userModel.setName("BigTailMonkey");
        userModel.setAge(18);
        userModel.setSex("man");
        CarModel carModel = new CarModel();
        carModel.setBrand("benz");
        carModel.setName("2000");
        NestedModel nestedModel = new NestedModel();
        nestedModel.setCarModel(carModel);
        nestedModel.setUserModel(userModel);
        nestedModel.setVersion(2.0f);
        return "Nested object return : "+demoClient.nestedObjectWithNestedObject(nestedModel);
    }

    @GetMapping("listWithSimpleParam")
    public String listWithSimpleParam(){
        List<NestedModel> nestedModels = demoClient.listWithSimpleParam(5);
        Assert.notEmpty(nestedModels,"返回值为空");
        StringBuilder stringBuilder = new StringBuilder();
        for (NestedModel nestedModel : nestedModels){
             stringBuilder.append(nestedModel.toString());
        }
        return stringBuilder.toString();
    }

}
