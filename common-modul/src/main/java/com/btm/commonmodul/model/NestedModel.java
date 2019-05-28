package com.btm.commonmodul.model;

import lombok.Data;

/**
 * 嵌套对象
 * @Author: BigTailMonkey
 * @Date: 2019/5/28 14:02
 * @Version: 1.0
 */
@Data
public class NestedModel {

    private UserModel userModel;
    private CarModel carModel;
    private float version;
}
