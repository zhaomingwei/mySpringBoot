package com.zw.cn.myspringboot.interfaceAutoTest;

import com.alibaba.fastjson.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/11/1
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
public class JSONParser {
    JSONObject internalJSON;

    public String getErrorCode(JSONObject jo){
        String city = "";
        try {
            //先获取反馈中的result这个一个内部JSON对象　
//            JSONObject internalJSON = jo.getString("result");
//            jo.get
            //再根据键名查找键值
            city = jo.getString("errorCode") ;
            System.out.println("errorCode:" + city);
        }catch (Exception e){
            e.printStackTrace();
        }
        return city;
    }
}
