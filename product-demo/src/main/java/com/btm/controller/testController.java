package com.btm.controller;

import com.btm.commonmodul.model.CarModel;
import com.btm.commonmodul.model.NestedModel;
import com.btm.commonmodul.model.UserModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试接口
 * @Author： BigTailMonkey
 * @Date： 2019-05-27
 * @Version： 1.0
 */
@RequestMapping("test")
@RestController
public class testController {

    /**
     * @require 无参数 GET
     * @return 简单String字符串
     */
    @GetMapping("simpleStringWithNoParam")
    public String simpleStringWithNoParam(){
        return "Return a simple string without require parameter.";
    }

    /**
     * @require 单个简单基本类型参数 GET
     * @param name
     * @return 简单String字符串
     */
    @GetMapping("simpleStringWithOneParam")
    public String simpleStringWithOneParam(String name){
        return "One parameter value : "+name;
    }

    /**
     * @require 多个简单基本类型参数 Get
     * @param name
     * @return 简单String字符串
     */
    @GetMapping("simpleStringWithMultiParam")
    public String simpleStringWithMultiParam(String name,int id){
        return "One parameter value : "+name+",id :"+id;
    }

    /**
     * @require 单个对象参数 Post
     * @param userModel
     * @return 简单String字符串
     */
    @PostMapping("simpleStringWithOneObject")
    public String simpleStringWithOneObject(@RequestBody UserModel userModel){
        return "One object parameter value :"+ userModel.toString();
    }

    /**
     * @require 单个对象参数 Post
     * @param userModel
     * @return 简单String字符串
     */
    @PostMapping("objectWithOneObject")
    public UserModel objectWithOneOjbect(@RequestBody UserModel userModel){
        UserModel model = new UserModel();
        model.setSex(userModel.getSex());
        model.setAge(userModel.getAge());
        model.setName("BTM");
        return model;
    }

    /**
     * 无法一次传送多个object对象参数
     * 遂将多个对象参数封装为一个对象
     * @require 单个 嵌套 对象参数
     * @param nestedModel
     * @return 简单String字符串
     */
    @PostMapping("simpleStringWithNestedObject")
    public String simpleStringWithNestedObject(@RequestBody NestedModel nestedModel){
        return nestedModel.toString();
    }

    /**
     * @require 单个 嵌套 对象参数
     * @param nestedModel
     * @return 单个 嵌套 对象参数
     */
    @PostMapping("nestedObjectWithNestedObject")
    public NestedModel nestedObjectWithNestedObject(@RequestBody NestedModel nestedModel){
        nestedModel.setVersion(2.5f);
        return nestedModel;
    }

    /**
     * 单个 简单 基本数据类型
     * @param i
     * @return 集合
     */
    @PostMapping("listWithSimpleParam")
    public List<NestedModel> listWithSimpleParam(@RequestBody int i){
        List<NestedModel> nestedModels = new ArrayList<>(i);
        for (;i>=0;i--){
            NestedModel nestedModel = new NestedModel();
            UserModel userModel = new UserModel();
            CarModel carModel = new CarModel();
            userModel.setName("BigTailMonkey");
            userModel.setSex("supperNam");
            userModel.setAge(18);
            carModel.setBrand("BMW");
            carModel.setName("X5");
            nestedModel.setVersion((float)i);
            nestedModel.setCarModel(carModel);
            nestedModel.setUserModel(userModel);
            nestedModels.add(nestedModel);
        }
        return nestedModels;
    }
}